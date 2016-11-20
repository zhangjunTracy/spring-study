package patterm.singleton;

/**
 * 懒汉模式 线程安全
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton11 {

    private static Singleton11 singleton1;

    private String name;

    private Singleton11(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Singleton11() {

    }

    // 获取方法加了同步锁,会影响性能
    public static synchronized Singleton11 getInstance() {
        if (singleton1 == null) { return new Singleton11("懒汉模式,调用的时候去实例化，获取方法加了同步锁,会影响性能,线程安全"); }
        return new Singleton11();

    }

}
