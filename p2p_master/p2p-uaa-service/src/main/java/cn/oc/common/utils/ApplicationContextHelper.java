package cn.oc.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : ApplicationContextHelper
 * @Author: oc
 * @Date: 2023/03/19/21:21
 * @Description:
 **/
@Component
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public ApplicationContextHelper() {
    }
    public static Object getBean(String beanName) {
        return applicationContext != null ? applicationContext.getBean(beanName) : null;
    }

    public static Object getBean(Class clazz) {
        return applicationContext != null ? applicationContext.getBean(clazz) : null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                ApplicationContextHelper.applicationContext =applicationContext;
    }
}
