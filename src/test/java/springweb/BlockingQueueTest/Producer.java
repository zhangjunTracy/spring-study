package springweb.BlockingQueueTest;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * 
 * @author Mr.Zhang
 * @param <T>
 * @Date 2016年9月21日
 * @Email zhangjun150429@qq.com
 */
public class Producer implements Runnable {

    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("启动生产者线程！" + Thread.currentThread().getName());
        System.out.println(queue.size() + "队列大小");
        try {
            while (true) {
                System.out.println("正在生产数据..." + Thread.currentThread().getName());
                queue.put(new Random().nextInt(10000));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
