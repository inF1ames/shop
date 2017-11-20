package com.company.shop.dao.impl;

import com.company.shop.converters.EntityDtoConverter;
import com.company.shop.dao.ItemDao;
import com.company.shop.dao.entity.Item;
import com.company.shop.model.dto.ItemDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.company.shop.converters.EntityDtoConverter.convert;
import static java.util.stream.Collectors.toList;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(ItemDto itemDto) {
        sessionFactory.getCurrentSession().save(convert(itemDto));
    }

    @Override
    public ItemDto findByTitle(String title) {
        Item item = (Item) sessionFactory.getCurrentSession()
                .createQuery("select i from Item i where i.title =:title")
                .setParameter("title", title)
                .uniqueResult();

        return convert(item);
    }

    @Override
    public ItemDto findById(int id) {
        Item item = (Item) sessionFactory.getCurrentSession()
                .createQuery("select i from Item i where i.id = :id")
                .setParameter("id", id)
                .uniqueResult();
        return convert(item);
    }

    @Override
    public List<ItemDto> findAll() {
        List<Item> items = sessionFactory.getCurrentSession()
                .createQuery("from Item")
                .list();
        return items.stream().map(EntityDtoConverter::convert).collect(toList());
    }

}
