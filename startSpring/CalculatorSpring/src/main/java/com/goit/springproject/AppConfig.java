package com.goit.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Bootstrap bootstrap() {
        Bootstrap bootstrap = new Bootstrap();

        return bootstrap;
    }

}