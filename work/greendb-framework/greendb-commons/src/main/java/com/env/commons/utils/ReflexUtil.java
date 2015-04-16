package com.env.commons.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 反射工具
 * 
 * @author yinfulei
 * 
 */
public class ReflexUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ReflexUtil.class);

    @SuppressWarnings("rawtypes")
    public static Object execMethod(Object obj, String methodName, Object[] paramObjects, Class... paramType)
            throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        Method execMethod = obj.getClass().getMethod(methodName, paramType);
        return execMethod.invoke(obj, paramObjects);
    }

    /**
	 * 只能对有相同对象属性（字段名 和字段类型）赋值， 对象属性必须有get/set方法
	 * 
	 * @param oldObject
	 * @param newObject
	 */
    public static void copyEntity(Object oldObject, Object newObject) {
        if (oldObject == null) {
            return;
        }
        String filedName = "";
        StringBuffer sbf = new StringBuffer(0);
        Map<String, Field> filedSet = new HashMap<String, Field>(0);
        Field[] fileds = oldObject.getClass().getDeclaredFields();
        getFiledSet(fileds, filedSet);
        getSupperFiledSet(oldObject.getClass(),filedSet);
        Iterator<String> ito = filedSet.keySet().iterator();
        while (ito.hasNext()) {
            filedName = ito.next();
            Field newObjectFiled = null;
            try {
                newObjectFiled = getFiled(newObject.getClass(), filedName);
                Field oldObjectFiled = filedSet.get(filedName);
                newObjectFiled.setAccessible(true);
                oldObjectFiled.setAccessible(true);
                Object oldValue = oldObjectFiled.get(oldObject);
                newObjectFiled.set(newObject, oldValue);
            } catch (NoSuchFieldException e) {
				sbf.append("【系统警告】").append(newObject.getClass().getName())
						.append(" 类中没有 ").append(filedName).append(" 字段，赋值失败！")
						.append(IOUtil.LINE_SEPARATOR_WINDOWS);
            } catch (IllegalArgumentException e) {
				sbf.append("【系统警告】").append(oldObject.getClass().getName())
						.append("类和").append(newObject.getClass().getName())
						.append(" 类的 ").append(filedName)
						.append("字段的get/set的方法参数不一致！赋值失败！")
						.append(IOUtil.LINE_SEPARATOR_WINDOWS);
            } catch (IllegalAccessException e) {
				sbf.append("【系统警告】").append(oldObject.getClass().getName())
						.append(" 类和 ").append(newObject.getClass().getName())
						.append(" 类的 ").append(filedName).append(" 的方法访问出错！")
                        .append(IOUtil.LINE_SEPARATOR_WINDOWS);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
        if (sbf.length() > 0) {
            LOG.info(IOUtil.LINE_SEPARATOR_WINDOWS + sbf.toString());
            sbf.delete(0, sbf.length());
        }
        filedSet = null;
    }
    
	/**
	 * 获取对象父类filed
	 * 
	 * @param newObject
	 * @param filedName
	 * @return
	 * @throws NoSuchFieldException
	 */
	private static void getSupperFiledSet(Class<?> classObj,
			Map<String, Field> filedSet){
		if(classObj == Object.class || classObj== null){
			return ;
		}
		Field[] fileds = classObj.getSuperclass().getDeclaredFields();
		getFiledSet(fileds, filedSet);
		getSupperFiledSet(classObj.getSuperclass(),filedSet);
	}
    
    /**
	 * 获取对象filed
	 * 
	 * @param newObject
	 * @param filedName
	 * @return
	 * @throws NoSuchFieldException
	 */
    private static Field getFiled(Class<?> newObjectClass, String filedName) throws NoSuchFieldException {
        Field newObjectFiled = null;
        if(newObjectClass == Object.class){
        	return newObjectClass.getDeclaredField(filedName);
    	}else if(newObjectClass == null){
    		return null;
    	}
        try {
            newObjectFiled = newObjectClass.getDeclaredField(filedName);
        } catch (NoSuchFieldException e) {
        	newObjectFiled = getFiled(newObjectClass.getSuperclass(),filedName);
        }
        return newObjectFiled;
    }

    /**
	 * 录入filed
	 * 
	 * @param fileds
	 * @param filedSet
	 */
    private static void getFiledSet(Field[] fileds, Map<String, Field> filedSet) {
        Map<String, Field> filedSets = filedSet;
        String filedName = "";
        for (int i = 0; i < fileds.length; i++) {
            filedName = fileds[i].getName();
            if (!filedSets.containsKey(filedName)) {
                filedSets.put(filedName, fileds[i]);
            }
        }
    }
}
