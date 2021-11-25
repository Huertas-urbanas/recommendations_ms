package com.huerta.recommendations_ms.exceptions;

public class RecommendationNotFoundException extends RuntimeException {

    public RecommendationNotFoundException(String message) {
        super(message);
    }
}
