package com.mg.aircondition;

import com.mg.aircondition.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.QAbstractAuditable;

@SpringBootApplication
public class AirConditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirConditionApplication.class, args);
    }

}

