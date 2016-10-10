package www.springweb.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Aspect:指定是一个切面
 */
@Aspect
@Component
public class AuthorizationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationAspect.class);

    // @Autowired
    // private YxAppLoginStatusRepositor appLoginStatusRepository;
    /**
     * 对于重复的切点,可以使用@Pointcut进行定义, 然后在通知注解内引用.
     * 引用切点@Before("AuthorizationAspect.anyPublicOperation1()") 如果在同一个类下可以省略类名
     * 这只是定义一个切入点，方便各种通知的引用，这个方法是没有实际意义的
     */
    @Pointcut("execution(public * *(..))")
    private void anyPublicOperation1() {
    }

    /**
     * 需要认证的方法 在有@Auth注解的方法才进行验证 才走个方法 也可以使用execution表达式
     * 
     * @param joinPoint
     */
    @Before("@annotation(com.china08.apiv3.annotations.Api3Auth)")
    private void apiAuth(JoinPoint joinPoint) {
        // LOGGER.info("认证开始" + StringUtils.repeat(".", 25));
        // AuthorizationInfo info = AuthorizationUtil.getAuthorizationInfo();
        // LOGGER.info(info.toString());
        // LOGGER.info(joinPoint.getTarget().getClass().getName() + "." +
        // joinPoint.getSignature().getName() + "("
        // + Arrays.asList(joinPoint.getArgs()) + ")");
        // Integer count =
        // appLoginStatusRepository.countByUsernameAndAuthCode(info.getUsername(),
        // info.getAuthcode());
        // if (count != 0) {
        // LOGGER.info("认证成功" + StringUtils.repeat(".", 25));
        // info.setAuthenticated(true);
        // } else {
        // LOGGER.error("认证失败" + StringUtils.repeat(".", 25));
        // throw new ApiException(HttpStatus.UNAUTHORIZED, "认证失败");
        // }
    }
}
