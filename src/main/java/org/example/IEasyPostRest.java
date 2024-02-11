package org.example;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public interface IEasyPostRest {

    String postExample(Body2Pass body);
}
