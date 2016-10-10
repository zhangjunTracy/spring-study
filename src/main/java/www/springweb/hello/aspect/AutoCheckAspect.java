package www.springweb.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面:自动检测参数
 * 
 * @author Ertao.Fang
 *
 */
@Aspect
@Component
public class AutoCheckAspect {

    /**
     * 需要自动检测的方法
     * 
     * @param joinPoint
     */
    // @Before("@annotation(io.swagger.annotations.ApiOperation)")
    private void autoCheck(JoinPoint joinPoint) {
        // 切入点的所有参数
        Object[] args = joinPoint.getArgs();
        // for (Object arg : args) {
        // if (arg instanceof Api3Model) {
        // Api3Model api3Model = (Api3Model) arg;
        // api3Model.autoCheck();
        // }
        // }
    }
}
