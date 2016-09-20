package springweb.ThreadTest;

public class OutputThread implements Runnable {

    private int num;
    private byte[] lock;

    public OutputThread(int num, byte[] lock) {
        super();
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {

                    // 通知 lock对象上的其它监线程
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        final byte[] lock = new byte[0];
        Thread thread1 = new Thread(new OutputThread(1, lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));
        thread1.start();
        thread2.start();
    }

}