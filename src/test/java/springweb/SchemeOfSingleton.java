package springweb;

/**
 * 
 * @author Mr.Zhang
 * @Date 2016年10月8日
 * @Email zhangjunTracy@qq.com
 */
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
