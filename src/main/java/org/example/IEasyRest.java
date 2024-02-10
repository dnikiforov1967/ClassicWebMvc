package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;


@Validated
public interface IEasyRest {
    //Liskov principle
    Integer easy(@Valid Horse horse, @NotNull(message="I am stupid") @Min(value=2, message="Minimum 2") Integer paramA);
}
