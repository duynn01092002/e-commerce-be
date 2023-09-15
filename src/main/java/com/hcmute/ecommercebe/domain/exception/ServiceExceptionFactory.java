package com.hcmute.ecommercebe.domain.exception;

import org.springframework.http.HttpStatus;

public class ServiceExceptionFactory {
    public ServiceExceptionFactory() {}

    public static ServiceExceptionBase notFound() {
        return new ServiceExceptionBase(HttpStatus.NOT_FOUND);
    }

    public static ServiceExceptionBase duplicate() {
        return new ServiceExceptionBase(HttpStatus.CONFLICT);
    }

    public static ServiceExceptionBase badRequest() {
        return new ServiceExceptionBase(HttpStatus.BAD_REQUEST);
    }

    public static ServiceExceptionBase unauthorized() {
        return new ServiceExceptionBase(HttpStatus.UNAUTHORIZED);
    }

    public static ServiceExceptionBase forbidden() {
        return new ServiceExceptionBase(HttpStatus.FORBIDDEN);
    }
}
