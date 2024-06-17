package com.borringtec.spring_data_jpa.controller;

import com.borringtec.spring_data_jpa.model.ItemOutModel;
import com.borringtec.spring_data_jpa.model.ItemModel;
import com.borringtec.spring_data_jpa.repository.ItemOutRepository;
import com.borringtec.spring_data_jpa.repository.ItemRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemOutController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemOutRepository itemOutRepository;

    @GetMapping(value = "/item-out")
    public List<ItemOutModel> findAll() {
        return itemOutRepository.findAll();
    }

    @GetMapping(value = "/item-out/{id}")
    public Optional<ItemOutModel> findById(@PathVariable("id") Long id) {
        return itemOutRepository.findById(id);
    }

    @DeleteMapping(value = "/item-out/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        itemOutRepository.deleteById(id);
    }

    @PostMapping(value = "/item-out")
    public void save(@RequestBody JsonNode payLoad) {
        String item = payLoad.get("item").toString();
        String amount = payLoad.get("amount").toString();
        ItemModel itemModel = itemRepository.findById(Long.valueOf(item)).get();
        ItemOutModel itemOut = new ItemOutModel();
        itemOut.setItem(itemModel);
        itemOut.setAmount(Integer.valueOf(amount));
        itemOutRepository.save(itemOut);
    }
}
