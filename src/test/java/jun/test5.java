package jun;

public class test5 {

    public static void main(String[] args) {
        new Child();
       // new Parent();
    }
}

class Parent {

    private int i = 2;

    public Parent() {
        display();
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

    private int i = 22;

    public Child() {
        i = 222;
    }

    public Child(int i) {
        this.i = i;
    }

    public void display() {
        System.out.println("Child:" + i);
    }
}