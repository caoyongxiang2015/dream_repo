package com.env.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 〈一句话功能简述〉<br> 
 * 自定义参数注释注解
 *
 * @author xuguozhen
 * @version [版本号, 2014-4-16]
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DescriptionParameter {
    
    // 参数类型
    public enum ParameterType {
        STRING, SHORT, INT, BOOL, LONG, OBJECT
    };

    // 参数名
    public String name();
    
    //  参数描述
    public String nameDesc();

    // 参数类型
    public ParameterType type() default ParameterType.STRING;
}
