package com.company.shop.model;

import com.company.shop.converters.EntityDtoConverter;
import com.company.shop.dao.ItemDao;
import com.company.shop.dao.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class CartParser {

    @Autowired
    private ItemDao itemDao;


    public List<Item> parse(String str) {
        String[] split = str.split("&");
        List<Item> carts = new ArrayList<>();
        for (String s : split) {
            String[] temp = s.split("=");
            carts.add(EntityDtoConverter.convert(itemDao.findById(Integer.parseInt(temp[0]) + 1)));
        }
        return carts;
    }
}
