package xuanhieu.com.project.service;

import org.springframework.web.multipart.MultipartFile;
import xuanhieu.com.project.model.Products;
import java.util.*;
public interface ProductService {

     String createProduct(String id, MultipartFile file,String name,Double salePrice,Integer amount,String status);

     List<Products> getListProducts();

     void deleteProductWithId(String id);

     Products getProductById(String id);
}
