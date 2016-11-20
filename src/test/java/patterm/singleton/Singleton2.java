package patterm.singleton;

/**
 * 懒汉模式 线程安全 jvm加载类时就初始化 如果用也会在内存中
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2("懒汉模式,线程安全 jvm加载类时就初始化 如果用也会在内存中");

    private String name;

    private Singleton2(String name) {
        this.name = name;
    }

    public static Singleton2 getInstance() {
        return singleton2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
