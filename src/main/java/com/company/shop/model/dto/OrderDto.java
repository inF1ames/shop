package com.company.shop.model.dto;

import com.company.shop.dao.entity.Item;

import java.util.List;

public class OrderDto {

    private Long id;
    private UserDto user;
    private List<Item> items;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
