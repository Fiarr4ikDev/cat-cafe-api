package ru.fiarr4ikdev.catcafeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;
import ru.fiarr4ikdev.catcafeapi.service.impl.CoffeeService;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<CoffeeDTO>> getAllCoffees() {
        return new ResponseEntity<>(coffeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeDTO> getCoffee(@PathVariable long id) {
        return new ResponseEntity<>(coffeeService.findOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable long id) {
        coffeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
