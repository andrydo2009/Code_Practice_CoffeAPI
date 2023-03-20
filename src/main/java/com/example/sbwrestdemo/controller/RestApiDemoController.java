package com.example.sbwrestdemo.controller;

import com.example.sbwrestdemo.model.Coffee;
import com.example.sbwrestdemo.service.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    //private final List<Coffee> coffees=new ArrayList<>();
    private final CoffeeRepository coffeeRepository;


    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeRepository.saveAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }


//    @RequestMapping(value="/coffees",method = RequestMethod.GET)
//    //RequestMethod.GET указывает что метод будет отвечать на запоросы по пути "/coffees"
//    Iterable<Coffee> getCoffees(){return coffees;}

    //@GetMapping("/show/all")
    //Iterable<Coffee> getCoffees(){return coffees;}
    // ТАК УПРОЩАЕТСЯ ПРИ ПОМОЩИ АННОТАЦИИ @GetMapping НАПИСАНИЕ КОДА ВЫШЕ

    @GetMapping("/show/all")
    Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

//    @GetMapping("/show/{id}")
//    Optional<Coffee> getCoffeeById(@PathVariable String id){
//        for (Coffee c:coffees) {
//            if(c.getId().equals(id)){
//                return Optional.of(c);
//            }
//        }
//        return Optional.empty();
//    }

    @GetMapping("/show/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffeeRepository.findById(id);
    }

    //    @PostMapping("/add")
//    Coffee postCoffee(@RequestBody Coffee coffee) {
//        coffees.add(coffee);
//        return coffee;
//    }

    @PostMapping("/add")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

//    @PutMapping("/put/{id}")
//    Coffee putCoffee(@RequestParam String id, @RequestBody Coffee coffee) {
//        int coffeeIndex = -1;
//        for (Coffee c : coffees) {
//            if (c.getId().equals(id)) {
//                coffeeIndex = coffees.indexOf(c); // indexOf ищем в строке символ если не встречаем возращаем -1
//                coffees.set(coffeeIndex, coffee); // добавляем элемент
//            }
//        }
//        return (coffeeIndex == -1) ?
//                new ResponseEntity<>(postCoffee(coffee), CREATED).getBody() :
//                new ResponseEntity<>(coffee, OK).getBody();
//    }

    @PutMapping("/put/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id,
                                     @RequestBody Coffee coffee) {
        return (coffeeRepository.existsById(id))
                ? new ResponseEntity<>(coffeeRepository.save(coffee),
                HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }
}
