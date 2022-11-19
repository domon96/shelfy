package com.shelfy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Instant expirationDate;
    private String description;
    private int count;

    public Item(Product product, Instant expirationDate, String description, int count){
        this.product=product;
        this.expirationDate=expirationDate;
        this.description=description;
        this.count=count;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return id == item.id && product == item.product && expirationDate == item.expirationDate && count == item.count && Objects.equals(description, item.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, expirationDate, description, count);
    }
}
