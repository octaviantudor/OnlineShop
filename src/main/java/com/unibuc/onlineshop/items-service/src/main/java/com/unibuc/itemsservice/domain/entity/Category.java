package com.unibuc.itemsservice.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categories")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


}
