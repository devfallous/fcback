package com.Foodcourt.fc.Repository;

import com.Foodcourt.fc.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepositary extends JpaRepository<Items,Integer> {
    Items getElementByCategory(String dishName);

    @Query("SELECT DISTINCT a.category FROM Items a")
    List<String> findDistinctCategory();

    void deleteByDishName(String dishName);

    @Modifying
    @Query("update Items u set u.dishName = ?2, u.imageUrl = ?3, u.category = ?4, u.price = ?5, u.availability = ?6 where u.id = ?1")
    void setItemsInfoById(int id,String dishName, String imageUrl,String category, Integer price,String availability);

    List<Items> findAll();
}
