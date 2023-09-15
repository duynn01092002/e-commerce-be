package com.hcmute.ecommercebe.domain.base;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class SuccessResponse extends ResponseBaseAbstract{
    public SuccessResponse() {
        this.setStatusCode(HttpStatus.OK);
    }

    @Override
    public void setStatusCode(HttpStatus statusCode) {
        assert statusCode.value() <= 399;
        super.setStatusCode(statusCode);
    }
}
