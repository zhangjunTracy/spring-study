package springweb.other;

/**
 * 成员内部类
 * 
 * @author Json
 *
 */
public class OuterClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    class InnerClass {
        public InnerClass() {
            // OuterClass.this代表外部对象
            name = "chenssy";
            age = 23;
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        // 内部类的创建需要先创建外部类
        OuterClass.InnerClass class1 = outerClass.new InnerClass();
        System.out.println(outerClass.getAge());
    }
}