package xuanhieu.com.project.controller;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xuanhieu.com.project.file.FileUploadUtil;
import xuanhieu.com.project.model.Products;
import xuanhieu.com.project.model.StoreHouse;
import xuanhieu.com.project.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(name = "/admin/create-product")
public class ProductController {
    private static String codeProduct;
    private static String nameProduct;
    private static String image;
    private static Integer amount;
    private static Double sale;
    private static String status;
    private Products products;
    private StoreHouse storeHouse;
    private List<Products>productsList;
    private String uploadDir;


    @Autowired
    ProductService productService;

    @PostMapping(value = "/sessionProduct")
    public String sessionProduct(HttpServletRequest httpServletRequest,
                                 @RequestParam("image") MultipartFile multipartFile,Model model){

        codeProduct = httpServletRequest.getParameter("MaSanPham");
        nameProduct = httpServletRequest.getParameter("TenSanPham");
        amount = Integer.parseInt(httpServletRequest.getParameter("Amount"));
        sale=Double.parseDouble(httpServletRequest.getParameter("SalePrice"));
        status = httpServletRequest.getParameter("Status");
        productService.createProduct(codeProduct,multipartFile,nameProduct,sale,amount,status);
        return "redirect:/products";
    }

    @RequestMapping(value = "/deleteProduct/{id}")
    public String deleteProductWithId(@PathVariable("id")String id,Model model){
       productService.deleteProductWithId(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/productEdit/{id}")
    public String getProductAfterEditProduct(@PathVariable("id")String id, Model model){
        Products products = productService.getProductById(id);
        model.addAttribute("product",products);
        return "productEdit";
    }

    @PostMapping(value = "/updateProduct")
    public String editProduct(@ModelAttribute("product") Products products, @RequestParam("imageEditProduct") MultipartFile file){
        codeProduct = products.getId();
          nameProduct=products.getName();
         amount = products.getAmount();
        sale=products.getSalePrice();
           status=products.getStatus();
        productService.createProduct(codeProduct,file,nameProduct,sale,amount,status);
        return "redirect:/products";
    }
}
