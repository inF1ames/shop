package com.company.shop.dao;

import com.company.shop.model.dto.OrderDto;

import java.util.List;

public interface OrderDao {

    void create(OrderDto orderDto);

    List<OrderDto> findAll();

    List<OrderDto> findAllOrdersByUserId(Long userId);


}
