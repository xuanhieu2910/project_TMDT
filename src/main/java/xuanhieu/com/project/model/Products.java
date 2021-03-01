package xuanhieu.com.project.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    private String id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    @Column
    private String name;
    @Column
    private Double salePrice;
    @Column
    private Integer amount;

    @Column
    private String status;

    @OneToOne(
            mappedBy = "products",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private StoreHouse storeHouse;


    @OneToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderDetails> orderDetails;


    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Products() {
    }

    public Products(String id, String image, String name, Double salePrice, Integer amount, String status) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.salePrice = salePrice;
        this.amount = amount;
        this.status = status;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public StoreHouse getStoreHouse() {
        return storeHouse;
    }

    public void setStoreHouse(StoreHouse storeHouse) {
        this.storeHouse = storeHouse;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
