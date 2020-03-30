package io.spring.guides.gs_producing_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SoapWsdlTrofimovApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWsdlTrofimovApplication.class, args);
    }
}