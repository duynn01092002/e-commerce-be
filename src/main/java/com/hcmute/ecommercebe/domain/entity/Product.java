package com.hcmute.ecommercebe.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_product")
public class Product {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="name")
    private String name;

    @Column(name="status")
    private boolean status;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="sold")
    private Integer sold;

    @Column(name="price")
    private Double price;

    @Column(name="sale_price")
    private Double salePrice;

    @Column(name="on_sale")
    private boolean onSale;

    @Column(name="color")
    private String color;

    @Column(name="guarantee")
    private String guarantee;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @ManyToOne
    @JoinColumn(name="brand_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Brand brand;
}
