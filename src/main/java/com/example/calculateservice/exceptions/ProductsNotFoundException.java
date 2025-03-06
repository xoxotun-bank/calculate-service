package com.example.calculateservice.exceptions;

public class ProductsNotFoundException extends RuntimeException {

    public ProductsNotFoundException() {
    }

    public ProductsNotFoundException(String message) {
        super(message);
    }

    public ProductsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
