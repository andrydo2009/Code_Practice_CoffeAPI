package com.example.sbwrestdemo;

import com.example.sbwrestdemo.model.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SbwrestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbwrestdemoApplication.class, args);
    }
/* Проще всего указать приложению на необходимость обработки классов,
 снабженных аннотацией @ConfigurationProperties, и добавления их свойств в объект Environment приложения.
 Это делается добавлением аннотации @ConfigurationPropertiesScan к основному классу приложения*/

    @Bean
    @ConfigurationProperties(prefix = "droid")
    Droid createDroid() {return new Droid();
    }
}



