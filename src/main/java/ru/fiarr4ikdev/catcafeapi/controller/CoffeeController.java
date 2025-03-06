package ru.fiarr4ikdev.catcafeapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(CoffeeController.BASE_URL)
@Tag(
    name = "Контроллер для управления сущностью Coffee"
)
public class CoffeeController {

    protected static final String BASE_URL = "/api/coffee";

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Operation(summary = "Добавить запись Coffee в базу данных")
    @PostMapping("/add")
    public ResponseEntity<CoffeeDTO> saveCoffee(@RequestBody CoffeeDTO coffee) {
        return new ResponseEntity<>(coffeeService.save(coffee), HttpStatus.CREATED);
    }

    @Operation(summary = "Показать все записи Coffee в виде листа содержащего объекты CoffeeDTO")
    @GetMapping("/all")
    public ResponseEntity<List<CoffeeDTO>> getAllCoffees() {
        return new ResponseEntity<>(coffeeService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Получить запись Coffee по его id")
    @GetMapping("get/{id}")
    public ResponseEntity<CoffeeDTO> getCoffee(@PathVariable long id) {
        return new ResponseEntity<>(coffeeService.findOne(id), HttpStatus.OK);
    }

    @Operation(summary = "Удалить запись Coffee по его id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable long id) {
        coffeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
