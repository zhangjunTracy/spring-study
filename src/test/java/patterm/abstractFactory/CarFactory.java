package patterm.abstractFactory;

public interface CarFactory {

    CarEngine makEngine();

    CarWheel makeWheel();

    default void zuhe() {

        CarEngine carEngine = makEngine();
        CarWheel carWheel = makeWheel();
        System.out.println(carWheel.getName() + "=========" + carEngine.getName());

    }

}
