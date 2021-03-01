package xuanhieu.com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import xuanhieu.com.project.model.Customer;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {


    @RequestMapping(value = "/createCustomer")
    public String createCustomer(){return "createCustomer";}

}
