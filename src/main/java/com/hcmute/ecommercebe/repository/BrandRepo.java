package com.hcmute.ecommercebe.repository;

import com.hcmute.ecommercebe.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepo extends JpaRepository<Brand, String> {
    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN TRUE ELSE FALSE END FROM Brand b WHERE b.id=:id")
    boolean existsById(@Param("id") String id);

    @Query("SELECT b FROM Brand b WHERE b.id=:id")
    Brand getById(@Param("id") String id);
}
