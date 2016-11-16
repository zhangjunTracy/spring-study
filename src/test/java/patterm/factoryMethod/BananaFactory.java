package patterm.factoryMethod;

import patterm.simpleFactory.Banana;
import patterm.simpleFactory.Fruit;

public class BananaFactory implements FactoryMethod {

    @Override
    public Fruit create() {

        return new Banana();
    }

}
