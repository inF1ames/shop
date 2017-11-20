package com.company.shop.converters;

import com.company.shop.dao.entity.Item;
import com.company.shop.dao.entity.Order;
import com.company.shop.dao.entity.User;
import com.company.shop.model.dto.ItemDto;
import com.company.shop.model.dto.OrderDto;
import com.company.shop.model.dto.UserDto;


public final class EntityDtoConverter {

    private EntityDtoConverter() {

    }

    public static User convert(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        return user;
    }

    public static UserDto convert(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setRole(user.getRole());
        return userDto;
    }

    public static Item convert(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        }

        Item item = new Item();
        item.setId(itemDto.getId());
        item.setTitle(itemDto.getTitle());
        item.setDescription(itemDto.getDescription());
        item.setPrice(itemDto.getPrice());
        item.setImage(itemDto.getImage());
        return item;
    }

    public static ItemDto convert(Item item) {
        if (item == null) {
            return null;
        }

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setTitle(item.getTitle());
        itemDto.setDescription(item.getDescription());
        itemDto.setPrice(item.getPrice());
        itemDto.setImage(item.getImage());
        return itemDto;
    }

    public static OrderDto convert(Order order) {
        if (order == null) {
            return null;
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUser(convert(order.getUser()));
        orderDto.setItems(order.getItems());
        return orderDto;
    }

    public static Order convert(OrderDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        order.setId(orderDto.getId());
        order.setUser(convert(orderDto.getUser()));
        order.setItems(orderDto.getItems());
        return order;
    }
}
