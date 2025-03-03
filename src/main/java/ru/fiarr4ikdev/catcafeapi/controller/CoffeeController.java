package ru.fiarr4ikdev.catcafeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;
import ru.fiarr4ikdev.catcafeapi.service.CoffeeService;

@RestController
@RequestMapping("/cat-cafe/api")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<CoffeeDTO> saveCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>(coffeeService.save(coffee), HttpStatus.CREATED);
    }
}
