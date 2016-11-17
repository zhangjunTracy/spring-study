package patterm.abstractFactory;

import org.junit.Test;

/**
 * 抽象工厂模式:使一个工厂可以创建多个类对象,而这些对象之间存在一定的关联，或者说抽象工厂是 创建多个内在关联的对象即对象族 四个角色:抽象工厂 具体工厂
 * 抽象产品 具体产品 设计模式一书对抽象工厂的定义:抽象工厂模式提供一个借口,用于创建相关或依赖对象的家族,而不需要明确指定具体类.
 * 抽象工厂允许客户使用抽象的借口来创建一组相关的产品,而不需知道实际产出的具体产品是什么.客户从具体的产品中解耦
 * 
 * @author Mr.Zhang
 * @Date 2016年11月17日
 * @Email zhangjunTracy@qq.com
 */
public class Demo {

    @Test
    public void test() {
        CarFactory bmwCarFactory = new BMWCarFactory();
        bmwCarFactory.zuhe();
        CarFactory bmwCarFactory1 = new VWCarFactory();
        bmwCarFactory1.zuhe();

    }

}
