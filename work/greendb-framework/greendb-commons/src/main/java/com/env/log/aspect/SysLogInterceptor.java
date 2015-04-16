package com.env.log.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.env.log.beans.SysLog;
import com.env.log.beans.SysLog.SysLogType;
import com.env.log.thread.SysLogBuildThread;


/**
 * 系统日志切面，用于记录系统日志（方法调用）
 * 
 *         2014年11月16日 下午20:22:39
 */
@Component("sysLogInterceptor")
public class SysLogInterceptor {

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger("sysLog");

    /**
     * 线程安全的方法名称
     */
    private static final ThreadLocal<String> METHOD_NAME_LOCAL = new ThreadLocal<String>();

    /**
     * 当方法执行开始前
     * 
     * @param joinPoint
     *            接入点
     */
    public void doBefore(JoinPoint joinPoint) {
    }

    /**
     * 当方法执行结束后
     * 
     * @param joinPoint
     *            接入点
     */
    public void doAfter(JoinPoint joinPoint) {
    }

    /**
     * 方法执行环绕
     * 
     * @param proceedingJoinPoint
     *            可执行的接入点
     * @return 原方法执行结果
     * @throws Throwable
     *             方法执行出现异常
     */
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        Object retVal = null;
        
        if (LOGGER.isDebugEnabled()) {
            // 打印方法开始
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.BEGIN,
                    getMethodName(proceedingJoinPoint)));
            // 打印方法参数
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.ARGS,
                    getMethodName(proceedingJoinPoint), proceedingJoinPoint
                            .getArgs()));
        } else if (LOGGER.isInfoEnabled()) {
            // 打印方法开始
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.BEGIN,
                    getMethodName(proceedingJoinPoint)));
        }
        
        long beginTime = System.currentTimeMillis();
        try {
            retVal = proceedingJoinPoint.proceed();
        } finally {
        	
            // 打印方法执行时间
            if (LOGGER.isWarnEnabled()) {
                long endTime = System.currentTimeMillis();
                SysLogBuildThread
                        .putSysLog(new SysLog(SysLogType.TIME,
                                getMethodName(proceedingJoinPoint), beginTime,
                                endTime));
            }
        }
        
        if (LOGGER.isDebugEnabled()) {
            // 打印方法结束
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.END,
                    getMethodName(proceedingJoinPoint)));
            // 打印方法返回结果
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.RETURN,
                    getMethodName(proceedingJoinPoint), retVal));
        } else if (LOGGER.isInfoEnabled()) {
            // 打印方法结束
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.END,
                    getMethodName(proceedingJoinPoint)));
        }
        
        return retVal;
    }

    /**
     * 方法执行抛出异常前
     * 
     * @param joinPoint
     *            接入点
     * @param ex
     *            异常体
     */
    public void doThrowing(JoinPoint joinPoint, Throwable ex) {
        if (LOGGER.isInfoEnabled()) {
            // 打印方法异常结束
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.EXCEPTION_END,
                    getMethodName(joinPoint)));
            // 打印方法执行异常
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.EXCEPTION,
                    getMethodName(joinPoint), ex));
        } else if (LOGGER.isErrorEnabled()) {
            // 打印方法执行异常
            SysLogBuildThread.putSysLog(new SysLog(SysLogType.EXCEPTION,
                    getMethodName(joinPoint), ex));
        }
    }

    /**
     * 获取方法名称
     * 
     * @param joinPoint
     *            接入点
     * @return 方法名称
     */
    private String getMethodName(JoinPoint joinPoint) {
        String methodName = METHOD_NAME_LOCAL.get();
        if (null == methodName) {
            methodName = joinPoint.getTarget().getClass().getName() + "."
                    + joinPoint.getSignature().getName();
            METHOD_NAME_LOCAL.set(methodName);
        }
        return methodName;
    }
}