package patterm.simpleFactory;

import org.junit.Test;

public class Demo {

    @Test
    public void demo() {
        SimpleFactory simpleFactory = new SimpleFactory();

        Fruit fruit = simpleFactory.getFruit(1);

        System.out.println(fruit.getColor());

    }

}
