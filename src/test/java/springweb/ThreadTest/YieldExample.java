package springweb.ThreadTest;

public class YieldExample {
    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        // 线程优先级
        producer.setPriority(Thread.MIN_PRIORITY); // Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); // Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();// 有可能让其它线程先运行 自己让出时间片
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}