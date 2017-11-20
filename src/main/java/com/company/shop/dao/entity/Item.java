package com.company.shop.dao.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "PRICE", nullable = false)
    private Integer price;
    @Column(name = "ICON")
    private String image;
    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
