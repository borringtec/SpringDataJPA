package com.borringtec.spring_data_jpa.model;

import jakarta.persistence.*;

@Entity @Table(name = "tb_item")
public class ItemModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
