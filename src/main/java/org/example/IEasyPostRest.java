package org.example;

import jakarta.validation.Valid;

public interface IEasyPostRest {

    String postExample(@Valid Body2Pass body);
}
