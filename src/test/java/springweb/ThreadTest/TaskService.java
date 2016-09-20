package springweb.ThreadTest;

import java.util.concurrent.Callable;

/**
 * 执行回调任务
 * 
 * @author Mr.Zhang
 * @Date 2016年9月20日
 * @Email zhangjun@91yunxiao.com
 */
public class TaskService implements Callable<String> {

    private int id;

    public TaskService(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被自动调用！！！    " + Thread.currentThread().getName());
        Thread.sleep(5000);
        // 该返回结果将被Future的get方法得到
        return "call()方法被自动调用,任务返回的结果是：" + id + "    " + Thread.currentThread().getName();
    }

}
