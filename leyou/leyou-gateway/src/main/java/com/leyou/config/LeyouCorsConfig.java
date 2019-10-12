package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//声明这是一个配置类
@Configuration
public class LeyouCorsConfig {
    //将这个组件注入到spring容器中
    @Bean
    public CorsFilter corsFilter() {
        //1.创建出CorsConfiguration实例对象，添加配置信息
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1）允许的域,不要写*，否则cookie就无法使用了
        corsConfiguration.addAllowedOrigin("http://manage.leyou.com");
        corsConfiguration.addAllowedOrigin("http://www.leyou.com");
        //2）是否发送Cookie信息
        corsConfiguration.setAllowCredentials(true);
        //3）允许的请求方式，*代表所有的请求方式
        corsConfiguration.addAllowedMethod("*");
        //4）允许的头信息
        corsConfiguration.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        //3.返回新的CorsFilter
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
