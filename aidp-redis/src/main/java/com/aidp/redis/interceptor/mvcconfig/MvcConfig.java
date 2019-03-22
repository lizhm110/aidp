package com.aidp.redis.interceptor.mvcconfig;

import com.aidp.redis.interceptor.AccessLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
 
/**
 * 拦截器配置
 * @Auther: lizhm
 * @Date: 2019-3-22 10:41:52
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
//    以下WebMvcConfigurerAdapter 比较常用的重写接口
//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//    /** 这里配置视图解析器 **/
//    void configureViewResolvers(ViewResolverRegistry registry);
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
 
    @Autowired
    private AccessLimitInterceptor accessLimitInterceptor;
 
    /**
     * 功能描述:
     *  配置静态资源,避免静态资源请求被拦截
     * @param: registry
     * @return:
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    /**
     * 功能描述:
     *  配置自定义拦截和例外
     * @param: registry
     * @return:
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLimitInterceptor)
                //addPathPatterns 用于添加拦截规则
                .addPathPatterns("/**");
                //excludePathPatterns 用于排除拦截
                //项目启动测试接口
                //.excludePathPatterns("/")
                //检查验证码
                //.excludePathPatterns("/test/**");
        super.addInterceptors(registry);
    }
}
