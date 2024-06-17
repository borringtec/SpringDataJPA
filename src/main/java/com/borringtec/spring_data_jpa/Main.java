package com.borringtec.spring_data_jpa;

import com.borringtec.spring_data_jpa.model.ItemInModel;
import com.borringtec.spring_data_jpa.model.ItemModel;
import com.borringtec.spring_data_jpa.model.ItemOutModel;
import com.borringtec.spring_data_jpa.repository.ItemInRepository;
import com.borringtec.spring_data_jpa.repository.ItemOutRepository;
import com.borringtec.spring_data_jpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemInRepository itemInRepository;
    @Autowired
    private ItemOutRepository itemOutRepository;

    @Override
    public void run(String... args) throws Exception {
        // Item 01
        ItemModel item01 = new ItemModel();
        item01.setDescription("Item 01");
        itemRepository.save(item01);
        // Item 02
        ItemModel item02 = new ItemModel();
        item02.setDescription("Item 02");
        itemRepository.save(item02);
        // Entry 01
        ItemInModel itemIn01 = new ItemInModel();
        itemIn01.setItem(item01);
        itemIn01.setAmount(10);
        itemInRepository.save(itemIn01);
        // Entry 02
        ItemInModel itemIn02 = new ItemInModel();
        itemIn02.setItem(item02);
        itemIn02.setAmount(20);
        itemInRepository.save(itemIn02);
        // Output 01
        ItemOutModel itemOut01 = new ItemOutModel();
        itemOut01.setItem(item01);
        itemOut01.setAmount(5);
        itemOutRepository.save(itemOut01);
        // Output 02
        ItemOutModel itemOut02 = new ItemOutModel();
        itemOut02.setItem(item02);
        itemOut02.setAmount(15);
        itemOutRepository.save(itemOut02);
    }
}
