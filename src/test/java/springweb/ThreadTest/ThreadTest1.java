package springweb.ThreadTest;

public class ThreadTest1 implements Runnable {

    private Thread thread;
    private String threadName;

    public ThreadTest1(String threadName) {
        thread = new Thread(this, threadName);
        this.threadName = threadName;
    }

    // 实现run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + ": " + i);
        }
    }

    public void start() {
        thread.start();
    }

}
