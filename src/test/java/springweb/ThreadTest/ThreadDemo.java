package springweb.ThreadTest;

public class ThreadDemo {

    public static void main(String[] args) {

        // java8 代替匿名内部类的方式
        // Thread thread2=new Thread(new Runnable() {
        // @Override
        // public void run() {
        // // TODO Auto-generated method stub
        // }
        // });
        Thread thread = new Thread(() -> {
            System.out.println("1231");
        });
        thread.start();

        // 继承Thread类
        Thread test = new ThreadTest("test11");
        test.start();
        // 实现runable接口
        ThreadTest1 test1 = new ThreadTest1("test1");
        test1.start();

        Thread test2 = new Thread(new ThreadTest2());
        test2.start();

    }

}
