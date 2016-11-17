package patterm.abstractFactory;

public class VWCarFactory implements CarFactory {

    @Override
    public CarEngine makEngine() {
        return new VWCarEngine();
    }

    @Override
    public CarWheel makeWheel() {
        return new VMCarWheel();
    }

}
