package patterm.simpleFactory;

public class SimpleFactory {

    public Fruit getFruit(Integer type) {
        Fruit fruit = null;
        if (type == 0) {
            fruit = new Apple();
        } else if (type == 1) {
            fruit = new Banana();
        } else {
            throw new IllegalArgumentException();
        }
        return fruit;

    }

}
