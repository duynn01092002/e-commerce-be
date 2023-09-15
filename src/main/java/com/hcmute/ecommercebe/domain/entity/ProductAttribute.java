package com.hcmute.ecommercebe.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_product_attribute")
public class ProductAttribute {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;
}
