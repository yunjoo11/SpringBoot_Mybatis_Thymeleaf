package com.joo.s1.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration
public class MessageLocaleConfig implements WebMvcConfigurer{
	@Bean
	public LocaleResolver localeResolver() {
		//session을 사용하여 설정
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN);
		
		//cookie 를 사용하여 설정
		CookieLocaleResolver cookieLocaleResolver =new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
		cookieLocaleResolver.setCookieName("lang");
		
		return cookieLocaleResolver;
	}
	
	//Interceptor
	@Bean
	public LocaleChangeInterceptor localChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor= new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		//parameter를 받아서 언어 구분
		//url?lang=en
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localChangeInterceptor())
				.addPathPatterns("/**");
	}

}
