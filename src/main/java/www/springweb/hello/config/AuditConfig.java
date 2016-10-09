package www.springweb.hello.config;

import org.apache.shiro.SecurityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import www.springweb.hello.entity.User;

/**
 * spring data jpa 审计功能
 * 
 * @author Mr.Zhang
 * @Date 2016年10月9日
 * @Email zhangjun150429@qq.com
 */
@Configuration
@EnableJpaAuditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        AuditorAware<String> auditorAware = new AuditorAware<String>() {

            @Override
            public String getCurrentAuditor() {
                try {
                    Object principal = SecurityUtils.getSubject().getPrincipal();
                    if (principal != null && principal instanceof User) { return ((User) principal).getId(); }
                } catch (Exception e) {
                }
                return null;
            }
        };
        return auditorAware;
    }
}
