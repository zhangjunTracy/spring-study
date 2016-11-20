package patterm.singleton;

import org.junit.Test;

/**
 * 设计模式对单列模式的定义:单件模式确保一个类只有一个实例,并提供一个全局访问点.
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */

public class Demo {

    @Test
    public void test() {

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getName());

        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1.getName());

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.getName());

        Singleton4 singleton4 = Singleton4.INSTANCE;

        System.out.println(singleton4.getName());

    }

}
