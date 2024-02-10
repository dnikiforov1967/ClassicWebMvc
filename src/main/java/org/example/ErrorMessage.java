package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String message;
    private int errorCode;
}
