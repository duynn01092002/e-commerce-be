package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, String> {
}
