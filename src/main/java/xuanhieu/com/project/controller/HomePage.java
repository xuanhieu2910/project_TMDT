package xuanhieu.com.project.controller;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import xuanhieu.com.project.dao.CustomerDao;
import xuanhieu.com.project.model.*;
import xuanhieu.com.project.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping(name = "/admin")
public class HomePage {

    private List<Products> products;
    private List<StoreHouse> storeHouseList;

    @Autowired
    ProductService productService;

    @Autowired
    StoreHouseService storeHouseService;

    @Autowired
    OrdersService ordersService;


    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "/")
    private String homePage() {
        return "index";
    }

    @GetMapping(value = "/create-order")
    private String createOrder(Model model) {
        storeHouseList = storeHouseService.findAllStoreHouse();
        model.addAttribute("storeHouses", storeHouseList);
        return "createOrder";
    }

    @RequestMapping(value = "/orders")
    private String orders(Model model) {
        List<Customer> customerList = customerService.findAllCustomer();
        model.addAttribute("listCustomer", customerList);
        return "orders";
    }

    @RequestMapping(value = "/create-product")
    private String createProduct() {
        return "createProduct";
    }

    @RequestMapping(value = "/products")
    private String products(Model model) {
        List<Products> productsList = productService.getListProducts();
        model.addAttribute("listProducts", productsList);
        return "products";
    }

    @RequestMapping(value = "/store-house")
    private String storeHouse(Model model) {
        storeHouseList = storeHouseService.findAllStoreHouse();
        model.addAttribute("storeHouseList", storeHouseList);
        return "storehouse";
    }


    @RequestMapping(value = "/customers")
    public String customer(Model model) {
        List<Customer> customers = customerService.findAllCustomer();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).getCustomerName());
        }
        model.addAttribute("customer", customers);
        return "customer";
    }
}
