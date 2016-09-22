package springweb.BlockingQueueTest;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue
 * 
 * @author Mr.Zhang
 * @Date 2016年9月22日
 * @Email zhangjun150429@qq.com
 */
public class BlockingQueueTest {

    // @Test
    public void test() {
        try {

            /**
             * 数组实现的 第一个参数 容量大小 第二个boolean 是否是公平锁 内部使用ReentrantLock lock
             * 放入和去除用的一把锁
             */
            BlockingQueue<Integer> b = new ArrayBlockingQueue<>(10);
            /**
             * 而LinkedBlockingQueue之所以能够高效的处理并发数据，
             * 还因为其对于生产者端和消费者端分别采用了独立的锁来控制数据同步，这也意味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据
             * ，以此来提高整个队列的并发性能。
             * 作为开发者，我们需要注意的是，如果构造一个LinkedBlockingQueue对象，而没有指定其容量大小，
             * LinkedBlockingQueue会默认一个类似无限大小的容量（Integer.MAX_VALUE），这样的话，
             * 如果生产者的速度一旦大于消费者的速度，也许还没有等到队列满阻塞产生，系统内存就有可能已被消耗殆尽了。
             * 
             */
            BlockingQueue<Integer> c = new LinkedBlockingDeque<Integer>(10);

            b.poll();// 取出一个 没有返回null
            b.poll(1000, TimeUnit.MILLISECONDS);// 如果没有等1000s 如果还没有返回null

            b.take();// 会堵塞线程 知道有东西

            b.put(1);// 如果满了会堵塞线程
            b.offer(11);// 成功返回true
            // TimeUnit 时间精度
            b.offer(10, 1000, TimeUnit.SECONDS);

            b.add(10);// 满了会抛出异常
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        BlockingQueue<Integer> b = new ArrayBlockingQueue<>(10);

        Thread thread = new Thread(() -> {
            while (true) {
                // System.out.println(b.add(new Random().nextInt(100)));
                try {
                    b.put(new Random().nextInt(100));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(3000);
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(b.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

    }

}
