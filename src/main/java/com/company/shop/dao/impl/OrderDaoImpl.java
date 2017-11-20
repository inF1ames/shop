package com.company.shop.dao.impl;

import com.company.shop.converters.EntityDtoConverter;
import com.company.shop.dao.OrderDao;
import com.company.shop.dao.entity.Order;
import com.company.shop.model.dto.OrderDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.company.shop.converters.EntityDtoConverter.convert;
import static java.util.stream.Collectors.toList;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void create(OrderDto orderDto) {
        sessionFactory.getCurrentSession().save(convert(orderDto));
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = sessionFactory.getCurrentSession()
                .createQuery("from Order")
                .list();
        return orders.stream().map(EntityDtoConverter::convert).collect(toList());
    }

    @Override
    public List<OrderDto> findAllOrdersByUserId(Long userId) {
        List<Order> orders = sessionFactory.getCurrentSession()
                .createQuery("select o from Order o where user.id = :userId")
                .setParameter("userId", userId)
                .list();
        return orders.stream().map(EntityDtoConverter::convert).collect(toList());
    }

}
