package com.borringtec.spring_data_jpa.controller;

import com.borringtec.spring_data_jpa.model.ItemInModel;
import com.borringtec.spring_data_jpa.model.ItemModel;
import com.borringtec.spring_data_jpa.repository.ItemInRepository;
import com.borringtec.spring_data_jpa.repository.ItemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemInController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemInRepository itemInRepository;

    @GetMapping(value = "/item-in")
    public List<ItemInModel> findAll() {
        return itemInRepository.findAll();
    }

    @GetMapping(value = "/item-in/{id}")
    public Optional<ItemInModel> findById(@PathVariable("id") Long id) {
        return itemInRepository.findById(id);
    }

    @DeleteMapping(value = "/item-in/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        itemInRepository.deleteById(id);
    }

    @PostMapping(value = "/item-in")
    public void save(@RequestBody JsonNode payLoad) {
        String item = payLoad.get("item").toString();
        String amount = payLoad.get("amount").toString();
        ItemModel itemModel = itemRepository.findById(Long.valueOf(item)).get();
        ItemInModel itemIn = new ItemInModel();
        itemIn.setItem(itemModel);
        itemIn.setAmount(Integer.valueOf(amount));
        itemInRepository.save(itemIn);
    }
}
