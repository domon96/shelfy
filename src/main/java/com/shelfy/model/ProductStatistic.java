package com.shelfy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ProductStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int wastedQuantity;
    private int eatenQuantity;
    private LocalDate date;

    public ProductStatistic(){

    }

    public ProductStatistic(Product product, int wastedQuantity, int eatenQuantity, LocalDate date) {
        this.product = product;
        this.wastedQuantity = wastedQuantity;
        this.eatenQuantity = eatenQuantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getWastedQuantity() {
        return wastedQuantity;
    }

    public int getEatenQuantity() {
        return eatenQuantity;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductStatistic productStatistic = (ProductStatistic) obj;
        return id == productStatistic.id && product == productStatistic.product && wastedQuantity == productStatistic.wastedQuantity && eatenQuantity== productStatistic.eatenQuantity && date == productStatistic.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, wastedQuantity, eatenQuantity, date);
    }
}
