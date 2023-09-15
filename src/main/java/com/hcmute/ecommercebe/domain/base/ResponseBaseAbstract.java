package com.hcmute.ecommercebe.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public abstract class ResponseBaseAbstract {
    @JsonIgnore
    private HttpStatus statusCode;
    private boolean isSuccess;
    private Object data;
    private String message;

    public ResponseBaseAbstract() {
        this.statusCode = HttpStatus.OK;
        this.isSuccess = true;
        this.data = null;
        this.message = "";
    }
}
