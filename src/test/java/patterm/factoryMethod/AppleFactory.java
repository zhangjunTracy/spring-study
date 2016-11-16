package patterm.factoryMethod;

import patterm.simpleFactory.Apple;
import patterm.simpleFactory.Fruit;

/**
 * 苹果工厂
 * 
 * @author Mr.Zhang
 * @Date 2016年11月16日
 * @Email zhangjunTracy@qq.com
 */
public class AppleFactory implements FactoryMethod {

    @Override
    public Fruit create() {

        return new Apple();
    }

}
