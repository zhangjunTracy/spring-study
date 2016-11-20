package patterm.singleton;

/**
 * 使用枚举创建单利 简单安全一个enum常量（这里是INSTANCE）代表了一个enum的实例，
 * enum类型只能有这些常量实例。标准保证enum常量（INSTANCE）不能被克隆，
 * 也不会因为反序列化产生不同的实例，想通过反射机制得到一个enum类型的实例也是不行的
 * 
 * INSTANCE就是Singleton4的实例,调用构造方法
 * 
 * @author Mr.Zhang
 * @Date 2016年11月20日
 * @Email zhangjunTracy@qq.com
 */
public enum Singleton4 {

    INSTANCE("枚举类型的单例,Instance就是这个类的实例");

    private String name;

    private Singleton4(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
