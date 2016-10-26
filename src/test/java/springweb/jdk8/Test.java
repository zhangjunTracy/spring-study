package springweb.jdk8;

public class Test {
    /**
     * java8新增了接口的默认方法和类方法：
     * 
     * 以前，接口里的方法要求全部是抽象方法，java8以后允许在接口里定义默认方法和类方法：
     * 
     * 不同的是：
     * 
     * 默认方法可以通过实现接口的类实例化的对象来调用,而类方法只能在本接口中调用或在实现类中实现 相同点：
     * 
     * 1）都是抽象类型；
     * 
     * 2）都可以有实现方法（以前接口不行）；
     * 
     * 3）都可以不需要实现类或者继承者去实现所有方法，（以前不行，现在接口中默认方法不需要实现者实现）
     * 
     * 不同点：
     * 
     * 1）抽象类不可以多重继承，接口可以（无论是多重类型继承还是多重行为继承）；
     * 
     * 2）抽象类和接口所反映出的设计理念不同。其实抽象类表示的是"is-a"关系，接口表示的是"like-a"关系；
     * 
     * 3）接口中定义的变量默认是public static final
     * 型，且必须给其初值，所以实现类中不能重新定义，也不能改变其值；抽象类中的变量默认是 friendly
     * 型，其值可以在子类中重新定义，也可以重新赋值。
     * 
     * 
     * 
     * Note：friendly
     * 型：如果一个类、类属变量及方法不以public,protected,private这三种修饰符来修饰，它就是friendly类型的，
     * 那么包内的任何类都可以访问它，而包外的任何类都不能访问它(包括包外继承了此类的子类)，因此，这种类、类属变量及方法对包内的其他类是友好的，开放的，
     * 而对包外的其他类是关闭的。
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        DefaultInterface defaultInterface = new Demo();
        defaultInterface.test();
        DefaultInterface.test1();

        // Demo.test1();

        Demo demo = new Demo();
        demo.test();
        // demo.test1();

    }

}
