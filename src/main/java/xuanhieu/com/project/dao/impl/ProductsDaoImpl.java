package xuanhieu.com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.com.project.dao.ProductsDao;
import xuanhieu.com.project.model.Products;
import xuanhieu.com.project.repository.ProductsRepository;

import java.util.List;

@Repository
public class ProductsDaoImpl  implements ProductsDao {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public String createProduct(Products products) {
        productsRepository.save(products);
        return "Thêm thành công!";
    }

    @Override
    public List<Products> getListProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProductWithId(String id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Products getProductById(String id) {
        return productsRepository.getProductById(id);
    }
}
