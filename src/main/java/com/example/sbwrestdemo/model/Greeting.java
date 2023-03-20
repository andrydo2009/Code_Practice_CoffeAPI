package com.example.sbwrestdemo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
//Чтобы зарегистрировать класс Greeting для управления свойствами конфигурации,
// я добавил аннотацию @ConfigurationProperties и указал prefix, используемый для всех свойств из класса Greeting.

@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String name;
    private String coffee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoffee() {
        return coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }
}
