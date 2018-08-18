package jun;

public class test5 {

    public static void main(String[] args) {
        new Child();
       // new Parent();
    }
}

class Parent {
    private static String str="父类静态";


    static {
        System.out.println("父类代码快:"+str);
    }

    private int i = 2;

    public Parent() {
        System.out.println("父:"+i);
       // display();
        System.out.println("无参构造");
    }

    public Parent(int i) {
        System.out.println("有参构造");
        this.i = i;
    }

    public void display() {
        System.out.println("parent:" + i);
    }
}

class Child extends Parent {

    private static String str="子类静态";

    static {
        System.out.println("子类代码快" +str);
    }

    private int i = 22;

    public Child() {
        System.out.println("子:"+i);
        i = 222;
    }

    public Child(int i) {
        this.i = i;
    }

    public void display() {
        System.out.println("Child:" + i);
    }
}