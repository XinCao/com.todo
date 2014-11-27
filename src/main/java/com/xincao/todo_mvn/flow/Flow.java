package com.xincao.todo_mvn.flow;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author caoxin
 */
@Documented // 注解将被包含在javadoc中
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // 注解会在class文件中存在，在运行时可以通过反射获取到
public @interface Flow {

    public String value() default "";
}