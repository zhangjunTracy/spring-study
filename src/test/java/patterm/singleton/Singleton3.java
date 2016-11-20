package patterm.singleton;

/**
 * 双重校验锁 在jdk1.5之后 volatile关键字才起作用
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */
public class Singleton3 {

    private volatile static Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getSingleton() {

        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();

                }

            }

        }
        return singleton;
    }

}
