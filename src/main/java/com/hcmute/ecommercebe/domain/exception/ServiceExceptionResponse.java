package com.hcmute.ecommercebe.domain.exception;


import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;

public class ServiceExceptionResponse extends ResponseBaseAbstract {
    public ServiceExceptionResponse() {
        super();
        this.setSuccess(false);
    }
}
