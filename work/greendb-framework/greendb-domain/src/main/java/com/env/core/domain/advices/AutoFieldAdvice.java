//package com.env.core.domain.advices;
//
//import java.lang.reflect.Method;
//
//import org.springframework.aop.MethodBeforeAdvice;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.env.commons.AutoFieldsUtils;
//import com.env.core.domain.DomainObject;
//
//
///**
// * 
// * 自动填充公共属性<br>
// * 
// */
//public class AutoFieldAdvice implements MethodBeforeAdvice {
//    /**
//     * 字段自动填充工具
//     */
//    @Autowired
//    private AutoFieldsUtils autoFieldsUtils;
//
//    /**
//     * 在方法执行前操作
//     * 
//     * @param method 请求的方法
//     * @param args 请求参数
//     * @param target 目标对象
//     */
//    public void before(Method method, Object[] args, Object target) throws Throwable {
//        // 获取参数中DomainObject的子类
//        if (null != args) {
//            for (Object object : args) {
//                if (null != object && object instanceof DomainObject) {
//                    DomainObject domainObject = (DomainObject) object;
//                    autoFieldsUtils.setAutoFields(object, null == domainObject.getId());
//                }
//            }
//        }
//    }
//}