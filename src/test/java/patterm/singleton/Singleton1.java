package patterm.singleton;

/**
 * 懒汉模式 线程不安全
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton1 {

    private static Singleton1 singleton1;

    private String name;

    private Singleton1(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) { return new Singleton1("懒汉模式,调用的时候去实例化,线程不安全"); }
        return new Singleton1();

    }

}
