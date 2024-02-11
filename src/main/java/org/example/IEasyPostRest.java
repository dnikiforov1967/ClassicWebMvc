package org.example;

import jakarta.validation.constraints.NotNull;

public interface IEasyPostRest {

    String postExample(@NotNull(message="Missed body") @ConsistentBody2Pass Body2Pass body);
}
