package org.example;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class Body2Pass {

    @NotBlank(message="Field 'name' must not blank")
    private String name;
    @Positive(message="Field 'id' must be positive")
    private Integer id;
}
