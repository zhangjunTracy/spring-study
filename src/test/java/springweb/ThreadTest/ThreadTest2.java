package springweb.ThreadTest;

public class ThreadTest2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("================" + i);

        }
    }

}
