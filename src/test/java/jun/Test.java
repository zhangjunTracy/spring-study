package jun;

public class Test {
    static int num1 = 5;// 1.首先被加载
    final static String TEE_STRING = "dd";

    static {
        System.out.println("静态语句块已经被加载" + num1); // 2.被加载
    }

    int count = 0; // 5.被加载

    {
        System.out.println("普通语句块" + count++);// 6.被加载
    }

    public Test() {
        System.out.println("父类的构造方法在这时候加载count=" + count);// 7.被加载
    }
}
