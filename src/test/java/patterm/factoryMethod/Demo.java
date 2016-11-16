package patterm.factoryMethod;

import org.junit.Test;

import patterm.simpleFactory.Fruit;

/**
 * 工厂模式中的接口也可以使用抽象类
 * 
 * 创建对象有不是有一个工厂创建,而是有各个产品各自的工厂创建
 * 
 * @author Mr.Zhang
 * @Date 2016年11月16日
 * @Email zhangjunTracy@qq.com
 */
public class Demo {

    @Test
    public void test() {
        AppleFactory factoryMethod = new AppleFactory();
        Fruit apple = factoryMethod.create();
        System.out.println(apple.getName());

    }

}
