package com.env.log.beans;

/**
 * 
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 系统日志对象
 * 
 */
public class SysLog {
    /**
     * 日期格式化
     */
    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        };
    };

    /**
     * 创建时间<br>
     * 约等同于日志记录时间
     */
    private final Date createTime = new Date();

    /**
     * 系统日志类型
     */
    private SysLogType sysLogType;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数列表
     */
    private Object[] args;

    /**
     * 返回结果
     */
    private Object returnValue;

    /**
     * 异常信息
     */
    private Throwable ex;

    /**
     * 执行开始时间
     */
    private long beginTime;

    /**
     * 执行结束时间
     */
    private long endTime;

    /**
     * 构造方法<br>
     * 开始、结束、异常结束、耗时时可用
     * 
     * @param sysLogType
     *            系统日志类型
     * @param methodName
     *            方法名称
     */
    public SysLog(SysLogType sysLogType, String methodName) {
        this.sysLogType = sysLogType;
        this.methodName = methodName;
    }

    /**
     * 构造方法<br>
     * 打印参数时使用
     * 
     * @param sysLogType
     *            系统日志类型
     * @param methodName
     *            方法名称
     * @param args
     *            参数列表
     */
    public SysLog(SysLogType sysLogType, String methodName, Object[] args) {
        this(sysLogType, methodName);
        this.args = args;
    }

    /**
     * 构造方法<br>
     * 打印返回结果时使用
     * 
     * @param sysLogType
     *            系统日志类型
     * @param methodName
     *            方法名称
     * @param returnValue
     *            返回结果
     */
    public SysLog(SysLogType sysLogType, String methodName, Object returnValue) {
        this(sysLogType, methodName);
        this.returnValue = returnValue;
    }

    /**
     * 构造方法<br>
     * 打印异常时使用
     * 
     * @param sysLogType
     *            系统日志类型
     * @param methodName
     *            方法名称
     * @param ex
     *            异常结果
     */
    public SysLog(SysLogType sysLogType, String methodName, Throwable ex) {
        this(sysLogType, methodName);
        this.ex = ex;
    }

    /**
     * 构造方法<br>
     * 打印耗时时使用
     * 
     * @param sysLogType
     *            系统日志类型
     * @param methodName
     *            方法名称
     * @param beginTime
     *            开始时间
     * @param endTime
     *            结束时间
     */
    public SysLog(SysLogType sysLogType, String methodName, long beginTime,
            long endTime) {
        this(sysLogType, methodName);
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    /**
     * @return the sysLogType
     */
    public final SysLogType getSysLogType() {
        return sysLogType;
    }

    /**
     * @param sysLogType
     *            the sysLogType to set
     */
    public final void setSysLogType(SysLogType sysLogType) {
        this.sysLogType = sysLogType;
    }

    /**
     * @return the methodName
     */
    public final String getMethodName() {
        return methodName;
    }

    /**
     * @param methodName
     *            the methodName to set
     */
    public final void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * @return the args
     */
    public final Object[] getArgs() {
        return args;
    }

    /**
     * @param args
     *            the args to set
     */
    public final void setArgs(Object[] args) {
        this.args = args;
    }

    /**
     * @return the returnValue
     */
    public final Object getReturnValue() {
        return returnValue;
    }

    /**
     * @param returnValue
     *            the returnValue to set
     */
    public final void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }

    /**
     * @return the ex
     */
    public final Throwable getEx() {
        return ex;
    }

    /**
     * @param ex
     *            the ex to set
     */
    public final void setEx(Throwable ex) {
        this.ex = ex;
    }

    /**
     * @return the beginTime
     */
    public final long getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     *            the beginTime to set
     */
    public final void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return the endTime
     */
    public final long getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public final void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the createTime
     */
    public String getCreateTime() {
        return "[" + DATE_FORMAT.get().format(createTime) + "]";
    }

    /**
     * 系统日志类型
     * 
     */
    public static enum SysLogType {
        /**
         * 开始
         */
        BEGIN,
        /**
         * 参数
         */
        ARGS,
        /**
         * 结束
         */
        END,
        /**
         * 返回
         */
        RETURN,
        /**
         * 异常结束
         */
        EXCEPTION_END,
        /**
         * 异常信息
         */
        EXCEPTION,
        /**
         * 时间
         */
        TIME;
    }
}
