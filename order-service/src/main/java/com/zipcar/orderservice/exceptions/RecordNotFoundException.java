package com.zipcar.orderservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException {

    private String message;
}
