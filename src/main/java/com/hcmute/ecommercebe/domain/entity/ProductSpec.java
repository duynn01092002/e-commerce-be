package com.hcmute.ecommercebe.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_product_spec")
public class ProductSpec {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="product_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne
    @JoinColumn(name="product_attribute_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductAttribute productAttribute;
}
