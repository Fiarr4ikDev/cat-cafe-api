package ru.fiarr4ikdev.catcafeapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "CatCafeApi",
				description = "Spring boot REST API" ,
				version = "0.0.1",
				contact = @Contact(
						name = "Fiarr4ikDev",
						email = "fiarr4ikdev@gmail.com",
						url = """
                                https://t.me/fiarr4ikdev"""
				)
		)
)
public class CatCafeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatCafeApiApplication.class, args);
	}

}
