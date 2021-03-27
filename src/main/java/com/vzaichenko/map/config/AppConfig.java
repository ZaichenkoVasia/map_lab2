package com.vzaichenko.map.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
