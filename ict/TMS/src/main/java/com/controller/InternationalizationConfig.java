package com.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizationConfig extends WebMvcConfigurerAdapter {

// Create a SessionLocaleResolver object and set the default locale to English
// return the SessionLocaleResolver object
@Bean
public LocaleResolver localeResolver() {
SessionLocaleResolver s = new SessionLocaleResolver();
s.setDefaultLocale(Locale.ENGLISH);
return s;
}

// Create LocaleChangeInterceptor object and set the parameter name as language
// and return the localeChangeInterceptor
@Bean
public LocaleChangeInterceptor localeChangeInterceptor() {
LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
lci.setParamName("language");
return lci;

}

// register the LocaleChangeInterceptor
@Override
public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor(localeChangeInterceptor());

}

@Bean
 public MessageSource messageSource() {
ReloadableResourceBundleMessageSource messageSource= new ReloadableResourceBundleMessageSource();
messageSource.setBasename("classpath:messages");
messageSource.setDefaultEncoding("UTF-8");
return messageSource;
   }
@Bean
public LocalValidatorFactoryBean getValidator() {
   LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
   bean.setValidationMessageSource(messageSource());
   return bean;
}

}