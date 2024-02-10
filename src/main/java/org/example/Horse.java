package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class Horse {

    @NotBlank
    private String name;
}
