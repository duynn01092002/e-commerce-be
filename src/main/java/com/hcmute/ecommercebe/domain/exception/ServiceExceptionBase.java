package com.hcmute.ecommercebe.domain.exception;

import org.springframework.http.HttpStatus;

public class ServiceExceptionBase extends RuntimeException{
    private ServiceExceptionResponse serviceExceptionResponse;

    public ServiceExceptionBase(HttpStatus statusCode) {
        this.serviceExceptionResponse = new ServiceExceptionResponse();
        this.serviceExceptionResponse.setStatusCode(statusCode);
    }

    public ServiceExceptionBase setMessage(String message) {
        this.serviceExceptionResponse.setMessage(message);
        return this;
    }

    public ServiceExceptionBase withData(Object data) {
        this.serviceExceptionResponse.setData(data);
        return this;
    }

    public ServiceExceptionResponse getServiceExceptionResponse() {
        return serviceExceptionResponse;
    }

    public void setServiceExceptionResponse(ServiceExceptionResponse serviceExceptionResponse) {
        this.serviceExceptionResponse = serviceExceptionResponse;
    }
}
