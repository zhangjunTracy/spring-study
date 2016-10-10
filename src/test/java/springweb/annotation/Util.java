package springweb.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解处理类库(java.lang.reflect.AnnotatedElement)：
 * 
 * @author Mr.Zhang
 * @Date 2016年10月10日
 * @Email zhangjun150429@qq.com
 */
public class Util {

    public static void info(Class<?> clazz) {

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                System.out.println(annotation);
            }

            if (field.isAnnotationPresent(StudentName.class)) {
                StudentName name = field.getAnnotation(StudentName.class);
                System.out.println("学生姓名:" + name.value());
            } else if (field.isAnnotationPresent(Sex.class)) {
                Sex gender = field.getAnnotation(Sex.class);
                // System.out.println(field.getAnnotatedType());
                System.out.println("学生性别:" + gender.getGender());
            }

        }

    }

}
