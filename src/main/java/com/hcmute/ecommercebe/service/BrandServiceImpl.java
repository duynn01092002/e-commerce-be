package com.hcmute.ecommercebe.service;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.base.SuccessResponse;
import com.hcmute.ecommercebe.domain.dto.brand.CreateBrandRequest;
import com.hcmute.ecommercebe.domain.entity.Brand;
import com.hcmute.ecommercebe.domain.exception.ServiceExceptionFactory;
import com.hcmute.ecommercebe.repository.BrandRepo;
import com.hcmute.ecommercebe.service.interfaces.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public ResponseBaseAbstract createBrand(CreateBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        brand.setImage(request.getImage());

        this.brandRepo.save(brand);
        SuccessResponse response = new SuccessResponse();
        response.setMessage("Tao thanh cong");
        response.setData(brand);

        return response;
    }
}
