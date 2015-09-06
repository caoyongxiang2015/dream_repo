package com.env.core.domain.threadlocal;

import com.env.core.domain.UserAttributes;

/**
 * 
 * 本地线程用户属性备份工具<br>
 * 将用户属性写入本地线程，用于后续线程中获取
 * 
 */
public class UserAttributesThreadLocal {
    /**
     * 线程copy
     */
    private static final ThreadLocal<UserAttributes> THREAD_LOCAL = new ThreadLocal<UserAttributes>();

    /**
     * 获取线程Copy中的用户属性
     * 
     * @return 线程Copy中的用户属性
     */
    public static final UserAttributes get() {
        return THREAD_LOCAL.get();
    }

    /**
     * 设置线程Copy中的用户属性
     * 
     * @param userAttributes 线程Copy中的用户属性
     */
    public static final void set(UserAttributes userAttributes) {
        THREAD_LOCAL.set(userAttributes);
    }
}