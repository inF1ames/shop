package com.company.shop.dao;

import com.company.shop.model.dto.ItemDto;

import java.util.List;

public interface ItemDao {

    void create(ItemDto itemDto);

    ItemDto findByTitle(String title);

    ItemDto findById(int id);

    List<ItemDto> findAll();


}
