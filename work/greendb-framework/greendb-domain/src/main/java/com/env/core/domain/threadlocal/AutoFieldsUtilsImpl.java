//package com.env.core.domain.threadlocal;
//
//
//import org.springframework.stereotype.Component;
//
//import com.env.commons.AutoFieldsUtils;
//
//
///**
// * 
// * 自动属性填充工具<br>
// * 
// * @author caoyongxiang
// */
//@Component("autoFieldsUtils")
//public class AutoFieldsUtilsImpl extends AutoFieldsUtils {
//    @Override
//    protected Integer getCurrentUserId() {
//        return UserAttributesThreadLocal.get().getEmployeeId();
//    }
//
//    @Override
//    protected String getCurrentUserName() {
//        return UserAttributesThreadLocal.get().getNameCn();
//    }
//
//    @Override
//    protected String getCurrentUserIp() {
//        return UserAttributesThreadLocal.get().getCurrentUserIp();
//    }
//
//}