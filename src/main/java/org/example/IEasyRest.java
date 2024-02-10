package org.example;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public interface IEasyRest {

    String postExample(Body2Pass body2Pass);
    Integer getExample(Integer param2Pass);
}
