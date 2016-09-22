package springweb;

public class SchemeOfSingleton {

    private SchemeOfSingleton() {

    };

    private static class ladyHolder {
        private static final SchemeOfSingleton SINGLETON = new SchemeOfSingleton();
    }

    public static SchemeOfSingleton getInstance() {
        return ladyHolder.SINGLETON;
    }

}
