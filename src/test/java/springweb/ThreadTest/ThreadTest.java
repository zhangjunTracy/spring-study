package springweb.ThreadTest;

public class ThreadTest extends Thread {

    private String threadName;

    public ThreadTest(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + ": " + i);
        }

    }

}
