package com.levanov.pcshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String serialNumber;

    private String manufacturer;

    private Integer price;

    private Integer numberOfProductUnitsInStock;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberOfProductUnitsInStock() {
        return numberOfProductUnitsInStock;
    }

    public void setNumberOfProductUnitsInStock(Integer numberOfProductUnitsInStock) {
        this.numberOfProductUnitsInStock = numberOfProductUnitsInStock;
    }
}

