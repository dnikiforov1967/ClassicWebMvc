package org.example;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class Body2Pass {

    @NotBlank
    private String name;
}
