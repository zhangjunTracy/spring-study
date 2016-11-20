package patterm.singleton;

/**
 * 单例模式1 静态内部类的方式 线程安全
 * 
 * @author Mr.Zhang
 * @Date 2016年10月8日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton {

    private String name;

    // 私有的构造
    private Singleton(String name) {
        this.name = name;
    };

    // 私有的内部静态类
    private static class ladyHolder {
        private static final Singleton SINGLETON = new Singleton("静态内部类的方式创建单列");
    }

    // 公开的获取类的方法
    public static Singleton getInstance() {
        return ladyHolder.SINGLETON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
