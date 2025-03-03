package ru.fiarr4ikdev.catcafeapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;
import ru.fiarr4ikdev.catcafeapi.entity.Coffee;
import ru.fiarr4ikdev.catcafeapi.repo.CoffeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository, ModelMapperService modelMapperService) {
        this.coffeeRepository = coffeeRepository;
        this.modelMapperService = modelMapperService;
    }

    public CoffeeDTO save(CoffeeDTO coffeeDTO) {
        Coffee coffee = modelMapperService.convertToEntity(coffeeDTO);
        Coffee savedCoffee = coffeeRepository.save(coffee);
        return modelMapperService.convertToDto(savedCoffee);
    }

    public List<CoffeeDTO> findAll() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        return coffeeList.stream().map(modelMapperService::convertToDto).collect(Collectors.toList());
    }
}
