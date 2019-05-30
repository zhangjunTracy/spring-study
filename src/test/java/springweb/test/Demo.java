package springweb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // // 封装类 引用
        // Long long1 = null;
        // // 基本数据类型 值
        // long long2 = 0l;
        //
        // Long l1 = 1l;
        // Long l2 = 1l;
        //
        // String s = "Hello";
        // s = s + " World!";
        // System.out.println(s);
        // "12345897".substring(0, 12);

        SubClass[] subArray = { new SubClass(), new SubClass() };
        // System.out.println(subArray.getClass());

        // class [Lcollection.SubClass;
        BaseClass[] baseArray = subArray;
        // 运行时获得
        // System.out.println(baseArray.getClass());
         //baseArray[0] = new BaseClass();

        // java.util.Arrays.ArrayList
        List<String> list = Arrays.asList("abc");

        // class java.util.Arrays$ArrayList
        // System.out.println(list.getClass());

        // class [Ljava.lang.String;
        Object[] objArray = list.toArray();
        // System.out.println(objArray.getClass());

        // objArray[0] = new Object(); // cause ArrayStoreException

        // class java.util.ArrayList
        // class java.util.Arrays$ArrayList 同时实现了AbstractList
        List<String> dataList = new ArrayList<String>();
        dataList.add("one");
        dataList.add("two");

        System.out.println(dataList.getClass());

        Object[] listToArray = dataList.toArray();

        // class [Ljava.lang.Object;返回的是Object数组
        System.out.println(listToArray.getClass());

    }

}
