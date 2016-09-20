package springweb.ThreadTest;

class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " call notify()");
            // 唤醒当前的wait线程
            notify();
        }
    }

    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");

        synchronized (t1) {
            try {
                // 主线程
                System.out.println(Thread.currentThread().getName() + " start t1");

                // 主线程 启动“线程t1”
                t1.start();

                // 当前线程 主线程等待t1通过notify()唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()");
                t1.wait();

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}