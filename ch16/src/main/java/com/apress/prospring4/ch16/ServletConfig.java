package com.apress.prospring4.ch16;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.xml.MarshallingView;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.annotation.Resource;
import java.util.ArrayList;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.apress.prospring4.ch16", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION))
public class ServletConfig extends WebMvcConfigurerAdapter {
    @Bean
    public UrlBasedViewResolver tilesViewResolver() {
        UrlBasedViewResolver ret = new UrlBasedViewResolver();
        ret.setViewClass(TilesView.class);
        return ret;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer ret = new TilesConfigurer();
        ret.setDefinitions("/WEB-INF/layouts/layouts.xml", "/WEB-INF/views/**/views.xml");
        return ret;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
        registry.addInterceptor(new ThemeChangeInterceptor());
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
        ret.setBasenames("WEB-INF/i18n/messages", "WEB-INF/i18n/application");
        ret.setFallbackToSystemLocale(false);
        return ret;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver ret = new CookieLocaleResolver();
        ret.setCookieName("locale");
        return ret;
    }

    @Bean
    public ResourceBundleThemeSource themeSource() {
        ResourceBundleThemeSource ret = new ResourceBundleThemeSource();
        return ret;
    }

    @Bean
    public CookieThemeResolver themeResolver() {
        CookieThemeResolver ret = new CookieThemeResolver();
        ret.setCookieName("theme");
        ret.setDefaultThemeName("standard");
        return ret;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean ret = new LocalValidatorFactoryBean();
        ret.setValidationMessageSource(messageSource());
        return ret;
    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public FilterRegistrationBean springSecurityFilterChainRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(springSecurityFilterChain());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("springSecurityFilterChain");
        registration.setOrder(1);
        return registration;
    }

    public DelegatingFilterProxy springSecurityFilterChain() {
        return new DelegatingFilterProxy();
    }
}
