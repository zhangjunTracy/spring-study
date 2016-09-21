package springweb.ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskServiceTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        // 创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            // 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskService(i));
            // 将任务执行结果存储到List中
            resultList.add(future);
        }

        int i = 0;

        // 遍历任务的结果
        for (Future<String> fs : resultList) {
            try {

                // while (!fs.isDone()) {
                // Thread.sleep(100);
                // i++;
                // // 等任务完成
                // System.out.println(StringUtils.repeat(".", i));
                // }
                System.out.println("是否完成" + fs.isDone() + "===" + (i++));
                // fs.get() 堵塞住线程 知道结果完成
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
                // 中断线程 中断任务
                // fs.cancel(true);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
                executorService.shutdown();
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {
            }
            System.out.println("Finished all threads");
        }

    }

}
