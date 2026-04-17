package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.nt.interceptor.TimeCheckingInterceptor;

/**
 * 
 */
@Component
public class MyWebMVCConfigurer implements WebMvcConfigurer {
    @Autowired
	private TimeCheckingInterceptor tci;
    @Autowired
    private LocaleChangeInterceptor lci;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(tci);
        registry.addInterceptor(lci);
    }
}
