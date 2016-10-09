package springweb.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 学生姓名注解 在属性上
 * 
 * @author Mr.Zhang
 * @Date 2016年10月9日
 * @Email zhangjun150429@qq.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StudentName {
    /**
     * 权限public修饰或默认
     * 
     * @return
     */
    String value() default "";

}
