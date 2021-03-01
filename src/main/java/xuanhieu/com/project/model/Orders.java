package xuanhieu.com.project.model;

import javax.persistence.*;
import java.util.Date;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Orders {

    @Id
    private String id;
    @Column
    private Integer amount;
    @Column
    private String date;
    @Column
    private Double price;
    @Column
    private String pay;
    @Column
    private String ship;

    @OneToOne(
            mappedBy = "orders",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Customer customer;

    @OneToMany(
            mappedBy = "orders",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<OrderDetails> orderDetails;

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Orders() {
    }
    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Double getTotalPrice() {
        return price;
    }

    public void setTotalPrice(Double totalPrice) {
        this.price = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
