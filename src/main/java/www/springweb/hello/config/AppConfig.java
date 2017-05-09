package www.springweb.hello.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.fasterxml.jackson.databind.ObjectMapper;

import www.springweb.hello.util.ServletContextUtil;
import www.springweb.hello.util.SpringContextUtil;

/**
 * 
 * @author Mr.Zhang
 * @Date 2016年9月21日
 * @Email zhangjun150429@qq.com
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig implements SchedulingConfigurer {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }

    @Bean
    ServletContextUtil ServletContextUtil() {
        return new ServletContextUtil();
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(1024 * 1024 * 50);
        return factory.createMultipartConfig();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod = "shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(50);
    }

}
