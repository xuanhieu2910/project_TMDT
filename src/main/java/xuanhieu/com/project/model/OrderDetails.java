package xuanhieu.com.project.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails {

    @Id
    private String id;


    private Integer amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    public OrderDetails() {
    }

    public OrderDetails(String id, Integer amount, Products products) {
        this.id = id;
        this.amount = amount;
        this.products = products;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
