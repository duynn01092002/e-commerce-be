package com.hcmute.ecommercebe.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="tbl_brand")
public class Brand {
    @Id
    private String Id = UUID.randomUUID().toString();

    @Column(name="name")
    private String name;

    @Column(name="image")
    private String image;
}
