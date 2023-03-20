package com.example.sbwrestdemo.controller;

import com.example.sbwrestdemo.model.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final Greeting greeting;
    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }
    @GetMapping
    String getGreeting() {
        return greeting.getName();
    }
    @GetMapping("/coffee")
    String getNameAndCoffee() {
        return greeting.getCoffee();
    }

//    @Value("${greeting-name: Mirage}")
//    private String name;
//    // SpEL позволяет указывать после двоеточия значение по умолчанию — в данном примере Mirage — для случаев
//    // , когда переменная не описана в объекте Environment приложения.
//
//    @Value("${greeting-coffee: ${greeting-name} is drinking Cafe Cereza}")
//    private String coffee;
//
//    @GetMapping("/name")
//    public String getName() {
//        return name;
//    }
//    @GetMapping("/coffee")
//    public String getNameAndCoffee() {
//        return coffee;
//    }
}
