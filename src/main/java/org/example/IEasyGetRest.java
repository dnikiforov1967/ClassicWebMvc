package org.example;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public interface IEasyGetRest {
    Integer getExample(@Max(value=10) @NotNull(message="Parameter 'param' must be there") Integer param);
}
