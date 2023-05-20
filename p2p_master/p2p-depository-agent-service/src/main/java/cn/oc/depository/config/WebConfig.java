package cn.oc.depository.config;


import cn.oc.depository.interceptor.DepositoryNotifyVerificationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author yuelimin
 * @since 1.8
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private DepositoryNotifyVerificationInterceptor notifyVerificationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(notifyVerificationInterceptor).addPathPatterns("/gateway/**");
    }

    /**
     * 添加静态资源文件, 外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

        // 解决swagger无法访问
        registry
                .addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry
                .addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
    }
}
