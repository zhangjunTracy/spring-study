package www.springweb.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import www.springweb.hello.annotation.Auth;

import java.lang.reflect.Method;

/**
 * @Aspect:指定是一个切面
 */
@Aspect
@Component
public class AuthorizationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationAspect.class);

    /**
     * 对于重复的切点,可以使用@Pointcut进行定义, 然后在通知注解内引用.
     * 引用切点@Before("AuthorizationAspect.anyPublicOperation1()") 如果在同一个类下可以省略类名
     * 这只是定义一个切入点，方便各种通知的引用，这个方法是没有实际意义的
     */
    // 指定UserController下的所有的方法
    @Pointcut("execution(* www.springweb.hello.controller.UserController.*(..))")
    private void anyPublicOperation1() {
    }

    /**
     * 需要认证的方法 在有@Auth注解的方法才进行验证 才走个方法 也可以使用execution表达式
     *
     * @param joinPoint
     */
    @Before("@annotation(www.springweb.hello.annotation.Auth)")
    private void apiAuth(JoinPoint joinPoint) {

        System.out.println("Hello world for aspect");

    }

    @Before("AuthorizationAspect.anyPublicOperation1()")
    private void apiAuth1(JoinPoint joinPoint) {

        // 获取连接点的参数
        Object[] strings = joinPoint.getArgs();
        for (Object object : strings) {
            System.out.println("==========:" + object);
        }

        System.out.println("Hello world for aspect111111111111");

    }

    @Around("AuthorizationAspect.anyPublicOperation1()")
    private void apiAuth12(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {

        // 获取连接点的参数
        Object[] strings = joinPoint.getArgs();
        for (Object object : strings) {
            System.out.println("==========:" + object);
        }

        System.out.println("Hello world for aspect111111111111");


        Signature signature = joinPoint.getSignature();
        if(!(signature instanceof MethodSignature)){
            //出错
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //拿到的时接口不是实现类
        //methodSignature.getMethod();

        Method method = joinPoint.getTarget().getClass().getMethod(methodSignature.getName(),
                methodSignature.getMethod().getParameterTypes());

        Auth annotation = method.getAnnotation(Auth.class);



        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(annotation.value());
        EvaluationContext context = new StandardEvaluationContext();
        Object[] args=joinPoint.getArgs();
        String[] params=new DefaultParameterNameDiscoverer().getParameterNames(method);
        for (int i=0;i<args.length;i++){
            context.setVariable(params[i],i);
        }

        String key=expression.getValue(context).toString();


    }
}
