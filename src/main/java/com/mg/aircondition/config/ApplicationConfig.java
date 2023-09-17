package com.mg.aircondition.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;


@Configuration
public class ApplicationConfig {

//    @Bean
//    public Validator validator() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = (Validator) factory.getValidator();
//        factory.close();
//        return validator;
//    }
}
