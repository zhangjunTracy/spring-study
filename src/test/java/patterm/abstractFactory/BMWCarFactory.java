package patterm.abstractFactory;

public class BMWCarFactory implements CarFactory {

    @Override
    public CarEngine makEngine() {

        return new BMWCarEngine();
    }

    @Override
    public CarWheel makeWheel() {
        return new BMWCarWheel();
    }

}
