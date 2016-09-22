package springweb.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * @author Mr.Zhang
 * @Date 2016年9月21日
 * @Email zhangjun150429@qq.com
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(5);

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer = new Consumer(queue);

        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(producer3);

        executorService.execute(consumer);

    }

}
