package ru.fiarr4ikdev.catcafeapi.service;

import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;

import java.util.List;

public interface ICoffeeService {

    CoffeeDTO save(CoffeeDTO coffeeDTO);

    List<CoffeeDTO> findAll();

    CoffeeDTO findOne(Long id);

    void delete(Long id);

}
