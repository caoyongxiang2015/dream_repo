/**
 * 
 */
package com.env.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 死循环线程
 * 
 */
public abstract class AbstractWhileRunnable implements Runnable {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractWhileRunnable.class);

    /**
     * 延时毫秒数
     */
    private final long delayTime;

    /**
     * 构造死循环线程<br>
     * 
     * @param delayTime
     *            延时毫秒数 <br>
     *            如果设置小于等于0，默认使用1
     */
    public AbstractWhileRunnable(final long delayTime) {
        if (0 < delayTime) {
            this.delayTime = delayTime;
        } else {
            this.delayTime = 1;
        }
    }

    /**
     * 构造死循环线程<br>
     * 
     * 默认使用延时毫秒数为1
     */
    public AbstractWhileRunnable() {
        this(1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public final void run() {
        while (true) {
            try {
                execute();
            } catch (Throwable ex) {
                LOGGER.warn("线程执行过程发生异常", ex);
            } finally {
                try {
                    Thread.sleep(getDelayTime());
                } catch (Throwable ex) {
                    LOGGER.warn("线程睡眠过程发生异常", ex);
                }
            }
        }
    }

    /**
     * 获取延时毫秒数
     * 
     * @return 延时毫秒数
     */
    private final long getDelayTime() {
        return this.delayTime;
    }

    /**
     * 业务执行
     */
    protected abstract void execute() throws Exception;
}
