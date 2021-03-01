package xuanhieu.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import xuanhieu.com.project.dao.ProductsDao;
import xuanhieu.com.project.model.Products;
import xuanhieu.com.project.model.StoreHouse;
import xuanhieu.com.project.service.ProductService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductService {

    @Autowired
    ProductsDao productsDao;

    @Override
    public String createProduct(String id, MultipartFile file, String name, Double salePrice, Integer amount, String status) {
        Products products = new Products();
        products.setId(id);
        products.setName(name);
        products.setSalePrice(salePrice);
        products.setAmount(amount);
        products.setStatus(status);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(file.isEmpty()){
            System.out.println("Error");
        }
        try{
         products.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
        StoreHouse storeHouse = new StoreHouse("SH"+id,amount,amount,products);
        products.setStoreHouse(storeHouse);
        productsDao.createProduct(products);
        return "Thêm thành công!";
    }

    @Override
    public List<Products> getListProducts() {
        return productsDao.getListProducts();
    }

    @Override
    public void deleteProductWithId(String id) {
        productsDao.deleteProductWithId(id);
    }

    @Override
    public Products getProductById(String id) {
        return productsDao.getProductById(id);
    }
}
