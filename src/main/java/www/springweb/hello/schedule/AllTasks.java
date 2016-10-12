package www.springweb.hello.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 所有的定时任务
 * 
 * @author Mr.Zhang
 * @Date 2016年10月12日
 * @Email zhangjunTracy@qq.com
 */

@Component
@EnableScheduling
public class AllTasks {

    /**
     * 每3分钟执行一次
     */

    @Scheduled(fixedRate = 1000 * 60 * 3)
    public void task1() {

        System.out.println("Hello World");

    }

}
