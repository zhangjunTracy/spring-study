package www.springweb.hello.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 @Auth 自动检测
 * 
 * @author Mr.Zhang
 * @Date 2016年10月9日
 * @Email zhangjun150429@qq.com
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
}
