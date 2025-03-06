package ru.fiarr4ikdev.catcafeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "DTO сущности Coffee"
)
public class CoffeeDTO {

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private int price;

}
