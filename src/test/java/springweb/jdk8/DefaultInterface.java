package springweb.jdk8;

public interface DefaultInterface {

    default void test() {
        System.out.println("this is default function");
        test1();
    }

    static void test1() {
        System.out.println("this is static function");
    }

}
