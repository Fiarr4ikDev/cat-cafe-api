package ru.fiarr4ikdev.catcafeapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ikdev.catcafeapi.dto.CoffeeDTO;
import ru.fiarr4ikdev.catcafeapi.entity.Coffee;

@Service
public class ModelMapperService {

    private final ModelMapper modelMapper;

    @Autowired
    public ModelMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Coffee convertToEntity(CoffeeDTO coffeeDTO) {
        return modelMapper.map(coffeeDTO, Coffee.class);
    }

    public CoffeeDTO convertToDto(Coffee coffee) {
        return modelMapper.map(coffee, CoffeeDTO.class);
    }

}
