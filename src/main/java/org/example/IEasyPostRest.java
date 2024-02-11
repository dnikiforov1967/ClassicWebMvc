package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface IEasyPostRest {

    String postExample(@Valid @NotNull(message="Missed body") Body2Pass body);
}
