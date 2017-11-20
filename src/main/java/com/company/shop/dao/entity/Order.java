package com.company.shop.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ITEM_IN_ORDER", inverseJoinColumns = @JoinColumn(name = "ITEM_ID"),
            joinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}

