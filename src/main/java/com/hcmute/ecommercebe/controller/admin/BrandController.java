package com.hcmute.ecommercebe.controller.admin;

import com.hcmute.ecommercebe.domain.base.ResponseBaseAbstract;
import com.hcmute.ecommercebe.domain.dto.brand.CreateBrandRequest;
import com.hcmute.ecommercebe.domain.dto.brand.UpdateBrandRequest;
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

    @GetMapping("")
    public ResponseBaseAbstract getAllBrands() {
        return this.brandService.getAllBrands();
    }

    @GetMapping("{id}")
    public ResponseBaseAbstract getBrandById(@PathVariable String id) {
        return this.brandService.getBrandById(id);
    }

    @PutMapping("{id}")
    public ResponseBaseAbstract updateBrand(@PathVariable String id,
                                            @RequestBody UpdateBrandRequest request) {
        request.setId(id);
        return this.brandService.updateBrand(request);
    }

    @DeleteMapping("{id}")
    public ResponseBaseAbstract deleteBrand(@PathVariable String id) {
        return this.brandService.deleteBrandById(id);
    }
}
