package ru.fiarr4ikdev.catcafeapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("HideUtilityClassConstructor")
public class CatCafeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatCafeApiApplication.class, args);
    }

}
