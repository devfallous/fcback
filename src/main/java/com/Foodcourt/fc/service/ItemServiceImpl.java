package com.Foodcourt.fc.service;

import com.Foodcourt.fc.Entity.Items;
import com.Foodcourt.fc.Repository.ItemsRepositary;
import com.Foodcourt.fc.dto.ItemsDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemsRepositary itemsRepositary;

    public Items save(ItemsDetailsDTO itemsDetailsDTO)
    {
        Items items = new Items();
        items.setDishName(itemsDetailsDTO.getDishName());
        items.setAvailability(itemsDetailsDTO.getAvailability());
        items.setCategory(itemsDetailsDTO.getCategory());
        items.setPrice(itemsDetailsDTO.getPrice());
        items.setImageUrl(itemsDetailsDTO.getImageUrl());
        return itemsRepositary.save(items);
    }

    @Override
    public Items fetch(String category) {
        return itemsRepositary.getElementByCategory(category);
    }

    @Override
    public List<String> category() {
        return itemsRepositary.findDistinctCategory();
    }

    @Transactional
    @Override
    public void delete(String dishName) {
        itemsRepositary.deleteByDishName(dishName);
    }

    @Transactional
    @Override
    public void modify(Items items) {
        itemsRepositary.setItemsInfoById(items.getId(), items.getDishName(), items.getImageUrl(), items.getCategory(), items.getPrice(), items.getAvailability());
    }

    @Override
    public List<Items> fetchall() {
        return (List<Items>) itemsRepositary.findAll();
    }
}
