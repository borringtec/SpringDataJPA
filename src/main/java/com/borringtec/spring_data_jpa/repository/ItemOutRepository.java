package com.borringtec.spring_data_jpa.repository;

import com.borringtec.spring_data_jpa.model.ItemOutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOutRepository extends JpaRepository<ItemOutModel, Long> {
}
