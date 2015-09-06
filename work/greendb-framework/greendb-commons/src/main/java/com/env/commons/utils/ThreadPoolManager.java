package com.env.commons.utils;



import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * 线程池<br>
 * 
 */
@Controller
public class ThreadPoolManager {
    /**
     * 默认构造方法，保证Spring可以正常创建
     */
    public ThreadPoolManager() {
    	LOGGER.info("ThreadPoolManager.构造方法");
    }

    /**
     * 线程池管理类
     * 
     * @param runnables 线程列表
     */
    public ThreadPoolManager(Runnable... runnables) {
        putThread(runnables);
    }

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolManager.class);

    /**
     * 线程池
     */
    private static final ThreadPoolExecutor POOLEXECUTOR;

    /**
     * 初始化线程池
     */
    static {

        LOGGER.info("initlizing thread pool...");
        // 线程池维护线程的最少数量
        int corePoolSize = 5;
        // 线程池维护线程的最大数量
        int maximumPoolSize = 20;
        // 线程池所使用的缓冲队列大小
        int workQueueSize = 1000;
        // 线程池维护线程所允许的空闲时间
        int keepAliveTime = 60;
        try {
            // get and init thread pool paremeters
            String cps = MemoryPropertyPlaceholderConfigurer.getContextProperty("corePoolSize");
            if (StringUtils.isNotBlank(cps)) {
                corePoolSize = Integer.valueOf(cps);
            }
            String mps = MemoryPropertyPlaceholderConfigurer.getContextProperty("maximumPoolSize");
            if (StringUtils.isNotBlank(mps)) {
                maximumPoolSize = Integer.valueOf(mps);
            }
            String wqs = MemoryPropertyPlaceholderConfigurer.getContextProperty("workQueueSize");
            if (StringUtils.isNotBlank(wqs)) {
                workQueueSize = Integer.valueOf(wqs);
            }
            String kat = MemoryPropertyPlaceholderConfigurer.getContextProperty("keepAliveTime");
            if (StringUtils.isNotBlank(kat)) {
                keepAliveTime = Integer.valueOf(kat);
            }
        } catch (Exception e) {
            LOGGER.error("initlize thread pool parameters fail:" + e.getMessage()
                    + "please check the thread pool parameters in system.properties file.");
        }

        POOLEXECUTOR = new ThreadPoolExecutor(Integer.valueOf(corePoolSize), Integer.valueOf(maximumPoolSize),
                Long.valueOf(keepAliveTime), TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(
                        Integer.valueOf(workQueueSize)), new ThreadPoolExecutor.CallerRunsPolicy());

        LOGGER.info("corePoolSize:" + corePoolSize);
        LOGGER.info("maximumPoolSize:" + maximumPoolSize);
        LOGGER.info("workQueueSize:" + workQueueSize);
        LOGGER.info("keepAliveTime:" + keepAliveTime);
        LOGGER.info("initlize thread pool parameters success.");
    }

    /**
     * 将线程加入到线程池
     * 
     * @param runnables 线程列表
     */
    public static final void putThread(Runnable... runnables) {
        for (Runnable runnable : runnables) {
            addExecuteTask(runnable);
        }
    }

    /**
     * 向线程池中添加任务方法
     * 
     * @param task task
     */
    public static final void addExecuteTask(Runnable task) {
        if (task != null) {
            POOLEXECUTOR.execute(task);
        }
    }

    /**
	 * 
	 */
    public void shutdown() {
        POOLEXECUTOR.shutdown();
    }

    /**
     * 
     * @return List<Runnable>
     */
    public List<Runnable> shutdownNow() {
        return POOLEXECUTOR.shutdownNow();
    }

    /**
     * 
     * @return activeCount
     */
    public int activeCount() {
        return POOLEXECUTOR.getActiveCount();
    }

    /**
     * 
     * @return completedTaskCount
     */
    public long completedTaskCount() {
        return POOLEXECUTOR.getCompletedTaskCount();
    }

    /**
     * 
     * @return taskCount
     */
    public long taskCount() {
        return POOLEXECUTOR.getTaskCount();
    }

    /**
     * 
     * @return poolSize
     */
    public int poolSize() {
        return POOLEXECUTOR.getPoolSize();
    }

    /**
     * 
     * @return largestPoolSize
     */
    public int largestPoolSize() {
        return POOLEXECUTOR.getLargestPoolSize();
    }
}