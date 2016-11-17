package patterm.factoryMethod;

import org.junit.Test;

import patterm.simpleFactory.Fruit;

/**
 * 所有的工厂模式都是用来封装对象的创建 工厂模式中的接口也可以使用抽象类 工厂方法模式包含四个角色： 抽象工厂 具体工厂 抽象产品 具体产品
 * 在工厂方法模式中，对象的创建不再由核心工厂一个人去完成，而是将各个对象的创建交给具体的子工厂去做
 * 创建对象有不是有一个工厂创建,而是有各个产品各自的工厂创建.
 * 设计模式一书对工厂方法模式的定义:工厂方法模式定义了一个创建对象的接口,但由子类决定实例化的类是哪个一.工厂方法让类把实例化推迟到子类.
 * 工厂方法模式能够封装具体类型的实例化.
 * 
 * @author Mr.Zhang
 * @Date 2016年11月16日
 * @Email zhangjunTracy@qq.com
 */
public class Demo {

    @Test
    public void test() {
        FactoryMethod factoryMethod = new AppleFactory();
        Fruit apple = factoryMethod.create();
        System.out.println(apple.getName());

    }

}
