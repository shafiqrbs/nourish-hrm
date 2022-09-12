package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


/**
 * Created by Sohag on 29/08/2018.
 */
@Entity
@Table( name = "Products" )
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 256)
    @Column(name = "Name")
    private String name;

    @Column(name = "Price")
    private float price;

    @Column(name = "Quantity")
    private int quantity;

    @Size(max = 256)
    @Column(name = "CategoryName")
    private String categoryName;

    @Size(max = 256)
    @Column(name = "ManufacturerName")
    private String manufacturerName;

    protected Products() {
    }

    public Products(long id, String name, float price, int quantity, String categoryName, String manufacturerName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
        this.manufacturerName = manufacturerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
