package springweb.ThreadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import org.junit.Test;
import org.redisson.config.Config;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 
 * @author Json
 * @Date 2018年4月19日
 *
 */
/**
 * 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * 
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 
 * 而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 * 
 * 另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 * 
 * @author Json
 * @Date 2018年4月20日
 *
 */
public class ThreadOfCountDownLatchDemo {

    /**
     * CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，
     * 它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
     */
    // @Test
    public void test() {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            latch.countDown();
        }).start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。叫做回环是因为当所有等待线程都被释放以后，
     * CyclicBarrier可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
     * 
     * CyclicBarrier是可以重用的 CountDownLatch无法进行重复使用
     */

    // public static void main(String[] args) {
    // CyclicBarrier barrier = new CyclicBarrier(4, () -> {
    // System.out.println("当前线程" + Thread.currentThread().getName());
    // });
    //
    // for (int i = 0; i < 4; i++) {
    // new Thread(() -> {
    // try {
    // System.out.println("线程" + Thread.currentThread().getName() +
    // "正在写入数据...");
    // Thread.sleep(1000); // 以睡眠来模拟写入数据操作
    // System.out.println("线程" + Thread.currentThread().getName() +
    // "写入数据完毕，等待其他线程写入完毕");
    // barrier.await();
    // } catch (Exception e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // System.out.println("所有线程写入完毕，继续处理其他任务...");
    // }).start();
    // }
    // }

    // @Test
    public void test1() {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("当前线程" + Thread.currentThread().getName());
        });

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
                    Thread.sleep(1000); // 以睡眠来模拟写入数据操作
                    System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                    barrier.await();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("所有线程写入完毕，继续处理其他任务...");
            }).start();
        }

    }

    // @Test
    /**
     * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。信号量控制的是线程并发的数量。
     * 
     * @param args
     */
    public static void main1(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } // 以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                semaphore.release();
            }).start();

        }
    }

    /**
     * 限流工具类RateLimiter google开源工具包guava提供了限流工具类RateLimiter，该类基于“令牌桶算法”
     * 
     * @param args
     */
    public static void main2(String[] args) {
        testNoRateLimiter();
        testWithRateLimiter();
    }

    public static void testNoRateLimiter() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.println("call execute.." + i);

        }
        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    public static void testWithRateLimiter() {
        Long start = System.currentTimeMillis();
        RateLimiter limiter = RateLimiter.create(10.0); // 每秒不超过10个任务被提交
        for (int i = 0; i < 10; i++) {
            limiter.acquire(); // 请求RateLimiter, 超过permits会被阻塞
            System.out.println("call execute.." + i);

        }
        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    @Test
    public void testt() {
        Config config = new Config();
        // RedissonClient redisson = Redisson.create(config);
        // RMap<String, String> map = redisson.getMap("myMap");
        // RLock lock = redisson.getLock("myLock");
        //
        // RExecutorService executor =
        // redisson.getExecutorService("myExecutorService");

    }

}
