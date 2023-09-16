package com.hcmute.ecommercebe.service;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.base.SuccessResponse;
import com.hcmute.ecommercebe.domain.dto.brand.CreateBrandRequest;
import com.hcmute.ecommercebe.domain.dto.brand.UpdateBrandRequest;
import com.hcmute.ecommercebe.domain.entity.Brand;
import com.hcmute.ecommercebe.domain.exception.ServiceExceptionFactory;
import com.hcmute.ecommercebe.repository.BrandRepo;
import com.hcmute.ecommercebe.service.interfaces.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ResponseBaseAbstract getAllBrands() {
        List<Brand> brandList = this.brandRepo.findAll();

        SuccessResponse response = new SuccessResponse();
        response.setMessage("Lay du lieu thanh cong");
        response.setData(brandList);

        return response;
    }

    @Override
    public ResponseBaseAbstract getBrandById(String id) {
        if (!this.brandRepo.existsById(id)) {
            throw ServiceExceptionFactory.notFound().setMessage("Khong ton tai brand voi id = "+id);
        }

        Brand brand = this.brandRepo.getById(id);

        SuccessResponse response = new SuccessResponse();
        response.setMessage("Lay du lieu thanh cong");
        response.setData(brand);
        return response;
    }

    @Override
    public ResponseBaseAbstract updateBrand(UpdateBrandRequest request) {
        String id = request.getId();
        if (!this.brandRepo.existsById(id)) {
            throw ServiceExceptionFactory.notFound().setMessage("Khong ton tai brand voi id = "+id);
        }

        Brand brand = this.brandRepo.getById(id);
        brand.setName(request.getName());
        brand.setImage(request.getImage());
        this.brandRepo.save(brand);

        SuccessResponse response = new SuccessResponse();
        response.setMessage("Cap nhat du lieu thanh cong");
        response.setData(brand);
        return response;
    }

    @Override
    public ResponseBaseAbstract deleteBrandById(String id) {
        if (!this.brandRepo.existsById(id)) {
            throw ServiceExceptionFactory.notFound().setMessage("Khong ton tai brand voi id = "+id);
        }

        Brand brand = this.brandRepo.getById(id);
        this.brandRepo.delete(brand);

        SuccessResponse response = new SuccessResponse();
        response.setMessage("Xoa du lieu thanh cong");
        return response;
    }
}
