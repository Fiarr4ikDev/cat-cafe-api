package ru.fiarr4ikdev.catcafeapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;
import ru.fiarr4ikdev.catcafeapi.entity.Coffee;
import ru.fiarr4ikdev.catcafeapi.repo.CoffeeRepository;
import ru.fiarr4ikdev.catcafeapi.service.ICoffeeService;
import ru.fiarr4ikdev.catcafeapi.service.ModelMapperService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService implements ICoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository, ModelMapperService modelMapperService) {
        this.coffeeRepository = coffeeRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public CoffeeDTO save(CoffeeDTO coffeeDTO) {
        Coffee coffee = modelMapperService.convertToEntity(coffeeDTO);
        Coffee savedCoffee = coffeeRepository.save(coffee);
        return modelMapperService.convertToDto(savedCoffee);
    }

    @Override
    public List<CoffeeDTO> findAll() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        return coffeeList.stream().map(modelMapperService::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CoffeeDTO findOne(Long id) {
        return coffeeRepository.findById(id)
                .map(modelMapperService::convertToDto).orElse(null);
    }

    @Override
    public void delete(Long id) {
        coffeeRepository.deleteById(id);
    }

}
