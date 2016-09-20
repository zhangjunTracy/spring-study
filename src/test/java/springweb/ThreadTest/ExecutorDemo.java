package springweb.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author Mr.Zhang
 * @Date 2016年9月20日
 * @Email zhangjun@91yunxiao.com
 */
public class ExecutorDemo {

    public static void main(String[] args) {

        /**
         * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
         */
        // ExecutorService e = Executors.newCachedThreadPool();
        /**
         * 固定大小的线程池
         */
        ExecutorService executor = Executors.newFixedThreadPool(5);

        /**
         * 创建一个定长线程池，支持定时及周期性任务执行
         */
        // ExecutorService e2 = Executors.newScheduledThreadPool(5);
        /**
         * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
         */
        // ExecutorService e3 = Executors.newSingleThreadExecutor();

        // 开启是个线程 但是线程池中只有5个 会重复使用
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }

}
