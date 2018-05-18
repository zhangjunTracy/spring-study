package jun;

public class Test1 extends Test {

    static {
        System.out.println("静态语句块和静态变量被初始化的顺序与代码先后顺序有关"); // 4.被加载
    }

    static int num = 45;// 3.被加载

    static {
        System.out.println("9999:" + num); // 4.被加载
    }

    int numre = 0; // 8.被加载

    {
        numre++;
        System.out.println("numre" + numre);// 9.被加载

    }

    public Test1() {
        System.out.println("子类构造方法");// 10.被加载
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1);
    }
}
