package com.niudingfeng.financialplanner.config;

import com.niudingfeng.financialplanner.interceptor.FileTypeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author lin
 * @Date 2018/8/24 9:53
 * @Version 1.0
 **/
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FileTypeInterceptor())
                .addPathPatterns("/**/fileUpload").addPathPatterns("/**/upload");
        super.addInterceptors(registry);
    }
}
