package xuanhieu.com.project.dao;

import xuanhieu.com.project.model.Products;
import java.util.*;
public interface ProductsDao {

    String createProduct(Products products);

    List<Products>getListProducts();

    void deleteProductWithId(String id);

    Products getProductById(String id);


}
