package com.env.commons;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 〈一句话功能简述〉<br>
 * 自定义注释注解
 * 
 * @author xuguozhen
 * @version [版本号, 2014-4-16]
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface Description {

    // 方法的描述
    public String desc();

    // 返回值的描述
    public String returnDesc() default "";

    // 类型
    public enum type {
        STRING, SHORT, INT, BOOLEAN, LONG, INTEGER, OBJECT
    };

    // 类型
    public type type() default type.STRING;

    // 参数列表
    public DescriptionParameter[] parameters() default @DescriptionParameter(name = "", nameDesc = "");
}
