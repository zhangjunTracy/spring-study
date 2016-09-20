package www.springweb.hello.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public final class SpringContextUtil implements ApplicationContextAware {

    private ApplicationContext context;

    private static SpringContextUtil springContextUtil;

    private SpringContextUtil() {
    }

    public void setApplicationContext(
            final ApplicationContext applicationContext) {
        SpringContextUtil.getInstance().setContext(applicationContext);
    }

    private ApplicationContext getApplicationContext() {
        return context;
    }

    private void setContext(final ApplicationContext pContext) {
        this.context = pContext;
    }

    private static SpringContextUtil getInstance() {
        if (springContextUtil == null) {
            springContextUtil = new SpringContextUtil();
        }
        return springContextUtil;
    }

    public static ApplicationContext getCtx() {
        return SpringContextUtil.getInstance().getApplicationContext();
    }

    public static <T> T getBean(Class<T> beanType) {
        T t = getCtx().getBean(beanType);
        return t;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        T t = (T) getCtx().getBean(beanId);
        return t;
    }
}
