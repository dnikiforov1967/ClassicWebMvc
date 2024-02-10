package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public interface IEasyRest {
    //Liskov principle
    Integer easy(@Valid @NotNull(message = "WHat is it") Horse horse, @NotNull(message="I am stupid") @Min(value=2, message="Minimum 2") Integer paramA);
}
