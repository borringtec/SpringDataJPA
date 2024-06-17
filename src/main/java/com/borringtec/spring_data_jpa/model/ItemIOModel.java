package com.borringtec.spring_data_jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity @Table(name = "tb_item_io")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) @DiscriminatorColumn(name = "io")
public abstract class ItemIOModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne
    private ItemModel item;
    private Integer amount;

    public Long getId() {
        return id;
    }

    public ItemModel getItem() {
        return item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
