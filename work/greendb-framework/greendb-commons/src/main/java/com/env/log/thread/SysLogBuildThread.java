package com.env.log.thread;

/**
 * 
 */

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.env.commons.AbstractWhileRunnable;
import com.env.log.beans.SysLog;
import com.env.log.beans.SysLog.SysLogType;

/**
 * 系统日志构造线程<br>
 * 系统日志使用线程构造，降低对系统运行的影响
 * 
 */
public class SysLogBuildThread extends AbstractWhileRunnable {

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger("sysLog");

    /**
     * 系统日志队列
     */
    private static final Queue<SysLog> SYSLOG_QUEUE = new ConcurrentLinkedQueue<SysLog>();

    @Override
    protected void execute() throws Exception {
        SysLog sysLog = SYSLOG_QUEUE.poll();
        while (null != sysLog) {
            /**
             * 开始
             */
            if (SysLogType.BEGIN.equals(sysLog.getSysLogType())) {
                LOGGER.info(sysLog.getCreateTime() + sysLog.getMethodName()
                        + " begin");
            }
            /**
             * 参数
             */
            else if (SysLogType.ARGS.equals(sysLog.getSysLogType())) {
                LOGGER.debug(sysLog.getCreateTime() + "the args of "
                        + sysLog.getMethodName() + " is "
                        + object2String(sysLog.getArgs()));
            }
            /**
             * 结束
             */
            else if (SysLogType.END.equals(sysLog.getSysLogType())) {
                LOGGER.info(sysLog.getCreateTime() + sysLog.getMethodName()
                        + " end");
            }
            /**
             * 返回
             */
            else if (SysLogType.RETURN.equals(sysLog.getSysLogType())) {
                LOGGER.debug(sysLog.getCreateTime() + "the return of "
                        + sysLog.getMethodName() + " is "
                        + object2String(sysLog.getReturnValue()));
            }
            /**
             * 异常结束
             */
            else if (SysLogType.EXCEPTION_END.equals(sysLog.getSysLogType())) {
                LOGGER.info(sysLog.getCreateTime() + sysLog.getMethodName()
                        + " end with exception");
            }
            /**
             * 异常信息
             */
            else if (SysLogType.EXCEPTION.equals(sysLog.getSysLogType())) {
                LOGGER.error(sysLog.getCreateTime() + "the exception of "
                        + sysLog.getMethodName(), sysLog.getEx());
            }
            /**
             * 时间
             */
            else if (SysLogType.TIME.equals(sysLog.getSysLogType())) {
                LOGGER.warn(sysLog.getCreateTime() + sysLog.getMethodName()
                        + " execute use "
                        + (sysLog.getEndTime() - sysLog.getBeginTime()) + "ms");
            }
            sysLog = SYSLOG_QUEUE.poll();
        }
    }

    /**
     * 方法入参转化为JSON字符串
     * 
     * @param args
     *            方法入参
     * @return JSON字符串
     */
    private String object2String(Object[] args) {
        if( null == args ){
            return "null";
        }else{
            JSONArray jsonArray = JSONArray.fromObject(args);
            return jsonArray.toString();
        }
    }

    /**
     * 方法出参转化为JSON字符串
     * 
     * @param returnValue
     *            方法出参
     * @return JSON字符串
     */
    private String object2String(Object returnValue) {
        if(null == returnValue){
            return "null";
        }else{
            Class<?> clazz = returnValue.getClass();
            if( returnValue instanceof Collection<?> || clazz.isArray() ){
                JSONArray jsonArray = JSONArray.fromObject(returnValue);
                return jsonArray.toString();
            }else{
                JSONObject jsonObject = JSONObject.fromObject(returnValue);
                return jsonObject.toString();
            }
        }
    }

    /**
     * 新增系统日志
     * 
     * @param sysLog
     *            系统日志对象
     */
    public static final void putSysLog(SysLog sysLog) {
        SYSLOG_QUEUE.add(sysLog);
    }
}
