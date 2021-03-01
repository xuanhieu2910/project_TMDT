package xuanhieu.com.project.model;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "STOREHOUSE")
public class StoreHouse {

    @Id
    private String id;

    @Column
    private Integer inventory;

    @Column
    private Integer totalProduct;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;

    public StoreHouse() {
    }

    public StoreHouse(String id, Integer inventory, Integer totalProduct,
                     Products products) {
        this.id = id;
        this.inventory = inventory;
        this.totalProduct = totalProduct;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(Integer totalProduct) {
        this.totalProduct = totalProduct;
    }



    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
