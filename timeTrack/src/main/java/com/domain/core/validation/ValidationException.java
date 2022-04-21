package com.domain.core.validation;

/* Создали свой класс-исключение */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
