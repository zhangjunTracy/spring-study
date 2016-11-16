package patterm.factoryMethod;

import patterm.simpleFactory.Fruit;

/**
 * 工厂方法模式 工厂模式中的接口也可以使用抽象类
 * 
 * @author Mr.Zhang
 * @Date 2016年11月16日
 * @Email zhangjunTracy@qq.com
 */
public interface FactoryMethod {

    Fruit create();

}
