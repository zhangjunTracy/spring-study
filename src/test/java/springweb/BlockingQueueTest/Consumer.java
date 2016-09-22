package springweb.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 * 
 * @author Mr.Zhang
 * @Date 2016年9月21日
 * @Email zhangjun150429@qq.com
 */
public class Consumer implements Runnable {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程" + Thread.currentThread().getName());
        try {
            while (true) {
                System.out.println("消费者" + Thread.currentThread().getName());
                queue.take();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
