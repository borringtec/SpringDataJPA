package com.borringtec.spring_data_jpa.controller;

import com.borringtec.spring_data_jpa.model.ItemModel;
import com.borringtec.spring_data_jpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @GetMapping("/item")
    public List<ItemModel> findAll() {
        return itemRepository.findAll();
    }
    @GetMapping("/item/{id}")
    public Optional<ItemModel> findById(@PathVariable("id") Long id) {
        return itemRepository.findById(id);
    }
    @DeleteMapping("/item/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
    }
    @PostMapping("/item")
    public void save(@RequestBody ItemModel item) {
        itemRepository.save(item);
    }
}
