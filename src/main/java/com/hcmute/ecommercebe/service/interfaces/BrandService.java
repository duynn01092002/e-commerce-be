package com.hcmute.ecommercebe.service.interfaces;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.dto.brand.CreateBrandRequest;
import com.hcmute.ecommercebe.domain.entity.Brand;

public interface BrandService {
    ResponseBaseAbstract createBrand(CreateBrandRequest request);
}
