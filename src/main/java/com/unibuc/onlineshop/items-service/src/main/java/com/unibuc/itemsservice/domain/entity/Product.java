package com.unibuc.itemsservice.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    private Double price;

    @OneToOne
    @JoinColumn(name = "id_categories", referencedColumnName = "id_categories")
    private Category category;

}