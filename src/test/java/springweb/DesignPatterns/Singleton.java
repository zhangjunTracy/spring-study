package springweb.DesignPatterns;

/**
 * 单例模式
 * 
 * @author Mr.Zhang
 * @Date 2016年10月8日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton {

    private Singleton() {

    };

    private static class ladyHolder {
        private static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
        return ladyHolder.SINGLETON;
    }

}
