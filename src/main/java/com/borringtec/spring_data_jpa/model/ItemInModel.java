package com.borringtec.spring_data_jpa.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity @DiscriminatorValue("i")
public class ItemInModel extends ItemIOModel {
}
