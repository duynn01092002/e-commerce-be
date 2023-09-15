package com.hcmute.ecommercebe.controller.admin;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.dto.brand.CreateBrandRequest;
import com.hcmute.ecommercebe.service.interfaces.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/brand")
@CrossOrigin("*")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("")
    public ResponseBaseAbstract createBrand(@RequestBody CreateBrandRequest request) {
        return this.brandService.createBrand(request);
    }
}
