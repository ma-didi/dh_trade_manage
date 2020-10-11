package com.giao.ssm.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuchang
 * @date 2020/9/21 - 20:53
 */
@Configuration
public class MybatisPlusConfig {

    @Bean("paginationInterceptor")
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
