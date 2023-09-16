package com.hcmute.ecommercebe.domain.dto.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UpdateBrandRequest {
    @JsonIgnore
    private String id;
    private String name;
    private String image;
}
