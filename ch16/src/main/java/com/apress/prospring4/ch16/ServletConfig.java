package com.apress.prospring4.ch16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import javax.annotation.Resource;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com.apress.prospring4.ch16", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION))
public class ServletConfig {
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

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
//        ret.setBasename("classpath:WEB-INF/i18n");
        return ret;
    }
}
