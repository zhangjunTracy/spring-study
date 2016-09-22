package springweb.ConcurrentThread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Store {

    private Integer maxSize = 100;

    private List<Date> store;

    public Store() {
        store = new LinkedList<Date>();
    }

    public synchronized void set() {
        while (store.size() == maxSize) {
            try {
                System.out.println("已满,等待中。。。。。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        store.add(new Date());
        System.out.println(Thread.currentThread().getName() + "===" + store.size());
        notifyAll();
    }

    public synchronized void get() {
        while (store.size() == 0) {
            try {
                System.out.println("没有了,等待中。。。。。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ((LinkedList<Date>) store).poll();
        System.out.println(Thread.currentThread().getName() + "===" + store.size());
        notifyAll();
    }

}
