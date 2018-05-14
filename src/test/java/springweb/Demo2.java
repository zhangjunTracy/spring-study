package springweb;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) throws Exception {

        System.out.println(String.format("ddddc and dd='%s'", "1dd1"));

        Long now = new Date().getTime() - 1000 * 60 * 60 * 60 * 24;
        long between = ChronoUnit.YEARS.between(new Date(now).toInstant(), new Date().toInstant());
        System.out.println(between);
        // System.out.println(s.);
        // System.out.println(e);
        // Integer sDate =
        //
        // Integer eDate = Integer.valueOf(e + "");
        // System.out.println(sDate + "==" + eDate);

        // List<String> list = new ArrayList<>();
        // List<Integer> list2 = new ArrayList<>();
        Erasure<String> ss = new Erasure<String>("dddd");

        Class<? extends Erasure> class1 = ss.getClass();
        System.out.println(ss.getClass());

        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name " + field.getName() + " type:" + field.getType().getName());
        }

        Method[] declaredMethods = class1.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(" method:" + method.toString());
        }
        Method declaredMethod = class1.getDeclaredMethod("add", String.class);
        declaredMethod.invoke(ss, "ddddd");

        List<Integer> ls = new ArrayList<>();
        ls.add(123);

        Class<? extends List> class2 = ls.getClass();

        Method method = class2.getDeclaredMethod("add", Object.class);

        method.invoke(ls, "ddd");
        method.invoke(ls, 998);

        for (Object integer : ls) {
            System.out.println(integer);
        }

    }

}
