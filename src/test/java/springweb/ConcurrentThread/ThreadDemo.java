package springweb.ConcurrentThread;

/**
 * 使用wait 和notifyAll实现生产者和消费者模式 简单的例子
 * 
 * @author Mr.Zhang
 * @Date 2016年9月22日
 * @Email zhangjun150429@qq.com
 */
public class ThreadDemo {

    public static void main(String[] args) {

        Store storage = new Store();

        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        Thread thread2 = new Thread(producer);

        Thread thread3 = new Thread(producer);
        Thread thread4 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread thread5 = new Thread(consumer);

        thread1.start();
        thread2.start();

        thread3.start();

        thread4.start();

        thread5.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.start();

    }

}
