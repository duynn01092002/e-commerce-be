package com.hcmute.ecommercebe.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Violation {
    private String fieldName;
    private String errorMessage;
}
