//package com.env.commons;
//
//
//import java.util.Date;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.apache.commons.beanutils.PropertyUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * 属性自动填充工具
// * 
// * @author caoyongxiang
// * 
// */
//public abstract class AutoFieldsUtils {
//    /**
//     * 日志记录器
//     */
//    private static final Logger LOGGER = LoggerFactory.getLogger(AutoFieldsUtils.class);
//    /**
//     * createUserid
//     */
//    private static final String AUTO_CREATE_USER_ID_FIELD = "createUserid";
//    /**
//     * createUsername
//     */
//    private static final String AUTO_CREATE_USER_NAME_FIELD = "createUsername";
//    /**
//     * createDatetime
//     */
//    private static final String AUTO_CREATE_DATETIME_FIELD = "createDatetime";
//    /**
//     * createIp
//     */
//    private static final String AUTO_CREATE_IP_FIELD = "createIp";
//    /**
//     * updateUserid
//     */
//    private static final String AUTO_UPDATE_USER_ID_FIELD = "updateUserid";
//    /**
//     * updateUsername
//     */
//    private static final String AUTO_UPDATE_USER_NAME_FIELD = "updateUsername";
//    /**
//     * updateDatetime
//     */
//    private static final String AUTO_UPDATE_DATETIME_FIELD = "updateDatetime";
//    /**
//     * updateIp
//     */
//    private static final String AUTO_UPDATE_IP_FIELD = "updateIp";
//
//    /**
//     * 缓存指定对象是否有指定属性createUserid
//     */
//    private static final Map<String, Boolean> AUTO_CREATE_USER_ID_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性createUsername
//     */
//    private static final Map<String, Boolean> AUTO_CREATE_USER_NAME_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性createDatetime
//     */
//    private static final Map<String, Boolean> AUTO_CREATE_DATETIME_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性createIp
//     */
//    private static final Map<String, Boolean> AUTO_CREATE_IP_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性updateUserid
//     */
//    private static final Map<String, Boolean> AUTO_UPDATE_USER_ID_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性updateUsername
//     */
//    private static final Map<String, Boolean> AUTO_UPDATE_USER_NAME_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性updateDatetime
//     */
//    private static final Map<String, Boolean> AUTO_UPDATE_DATETIME_CACHE = new ConcurrentHashMap<String, Boolean>();
//    /**
//     * 缓存指定对象是否有指定属性updateIp
//     */
//    private static final Map<String, Boolean> AUTO_UPDATE_IP_CACHE = new ConcurrentHashMap<String, Boolean>();
//
//    /**
//     * 设置自动属性
//     * 
//     * @param entity 需要填充的对象
//     * @param create 是否为创建操作，创建时只设置创建时间、创建IP、创建人ID，创建人名称，否则只设置修改时间、修改IP、修改人ID、修改人姓名
//     */
//    public void setAutoFields(Object entity, boolean create) {
//        try {
//            // 顺序切勿调整，这样可以保证在未登录时，依然可以尽可能设置一些值
//            if (create) {
//                setCreateField(entity);
//            } else {
//                setUpdateField(entity);
//            }
//        } catch (Exception e) {
//            LOGGER.warn("用户信息无法获取，操作对象的用户相关信息将无法填充");
//        }
//    }
//
//    /**
//     * 设置修改参数
//     * 
//     * @param entity 实体
//     * @throws Exception 异常
//     */
//    private void setUpdateField(Object entity) throws Exception {
//        // 修改时间
//        setField(entity, AUTO_UPDATE_DATETIME_CACHE, AUTO_UPDATE_DATETIME_FIELD, getCurrentTimestamp());
//        // 请求IP
//        setField(entity, AUTO_UPDATE_IP_CACHE, AUTO_UPDATE_IP_FIELD, getCurrentUserIp());
//        // 修改用户ID
//        setField(entity, AUTO_UPDATE_USER_ID_CACHE, AUTO_UPDATE_USER_ID_FIELD, getCurrentUserId());
//        // 修改用户姓名
//        setField(entity, AUTO_UPDATE_USER_NAME_CACHE, AUTO_UPDATE_USER_NAME_FIELD, getCurrentUserName());
//    }
//
//    /**
//     * 设置创建参数
//     * 
//     * @param entity 实体
//     * @throws Exception 异常
//     */
//    private void setCreateField(Object entity) throws Exception {
//        // 创建时间
//        setField(entity, AUTO_CREATE_DATETIME_CACHE, AUTO_CREATE_DATETIME_FIELD, getCurrentTimestamp());
//        // 请求IP
//        setField(entity, AUTO_CREATE_IP_CACHE, AUTO_CREATE_IP_FIELD, getCurrentUserIp());
//        // 创建用户ID
//        setField(entity, AUTO_CREATE_USER_ID_CACHE, AUTO_CREATE_USER_ID_FIELD, getCurrentUserId());
//        // 创建用户姓名
//        setField(entity, AUTO_CREATE_USER_NAME_CACHE, AUTO_CREATE_USER_NAME_FIELD, getCurrentUserName());
//    }
//
//    /**
//     * 设置对象属性
//     * 
//     * @param entity the entity
//     * @param cache the cache
//     * @param fieldName 需要设置的属性
//     * @param fieldValue 属性值
//     * @throws Exception throw Exception
//     */
//    private void setField(Object entity, Map<String, Boolean> cache, String fieldName, Object fieldValue)
//            throws Exception {
//        Boolean needSet = isNeedSet(entity, cache, fieldName);
//        if (needSet) {
//            if (null == fieldValue) {
//                if (LOGGER.isWarnEnabled()) {
//                    LOGGER.warn("set " + fieldName + " for " + entity.getClass().getName() + " is null");
//                }
//            } else {
//                PropertyUtils.setProperty(entity, fieldName, fieldValue);
//            }
//        }
//    }
//
//    /**
//     * 是否需要设置<br>
//     * 当存在对应类信息，则获取，不存在则获取是否包含对应属性，将结果缓存起来以便后续使用
//     * 
//     * @param entity
//     * @param cache
//     * @param fieldName
//     * @return
//     * @throws Exception
//     */
//    private Boolean isNeedSet(Object entity, Map<String, Boolean> cache, String fieldName) throws Exception {
//        String clazzName = entity.getClass().getName();
//        Boolean needSet = cache.get(clazzName);
//        if (needSet == null) {
//            needSet = hasField(entity, fieldName);
//            cache.put(clazzName, needSet);
//        }
//        return needSet;
//    }
//
//    /**
//     * 是否包含指定属性
//     * 
//     * @param entity
//     * @param fieldName
//     * @return
//     */
//    private Boolean hasField(Object entity, String fieldName) {
//        Boolean result;
//        try {
//            result = PropertyUtils.getPropertyDescriptor(entity, fieldName) != null;
//        } catch (Throwable e) {
//            result = false;
//        }
//        return result;
//    }
//
//    /**
//     * 获取当前用户ID
//     * 
//     * @return 当前用户ID
//     */
//    protected abstract Integer getCurrentUserId();
//
//    /**
//     * 获取当前用户姓名
//     * 
//     * @return 当前用户姓名
//     */
//    protected abstract String getCurrentUserName();
//
//    /**
//     * 获取当前用户IP
//     * 
//     * @return 当前用户IP
//     */
//    protected abstract String getCurrentUserIp();
//
//    /**
//     * 获取当前时间
//     * 
//     * @return 当前时间
//     */
//    protected static Date getCurrentTimestamp() {
//        return new Date();
//    }
//}