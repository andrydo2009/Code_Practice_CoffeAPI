package com.example.sbwrestdemo.service;

import com.example.sbwrestdemo.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {
}
