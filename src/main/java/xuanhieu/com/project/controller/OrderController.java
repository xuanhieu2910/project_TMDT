package xuanhieu.com.project.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xuanhieu.com.project.model.*;
import xuanhieu.com.project.service.OrdersDetailsService;
import xuanhieu.com.project.service.OrdersService;
import xuanhieu.com.project.service.ProductService;
import xuanhieu.com.project.service.StoreHouseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.*;

@Controller
public class OrderController {

    private static int idOrderDetail = 0;

    private static int idCustomer = 0;

    private static int id = 0;

    private static int id_ordetails = 0;

    @Autowired
    ProductService productService;

    @Autowired
    OrdersService ordersService;


    @Autowired
    StoreHouseService storeHouseService;

    @Autowired
    OrdersDetailsService ordersDetailsService;


    @RequestMapping(value = "/list-orders")
    public String orders(Model model, HttpSession httpSession) {
        model.addAttribute("total", total(httpSession));
        return "listItemsOrder";
    }


    @RequestMapping(value = "/addCart/{id}")
    public String addCart(@PathVariable("id") String id_Product, HttpSession httpSession) {
        int quantity = 1;
        Products product = productService.getProductById(id_Product);
        if (product != null) {
            if (httpSession.getAttribute("orders") == null) {
                List<OrderDetails> orderDetails = new ArrayList<>();
                orderDetails.add(new OrderDetails("SapoOrderDetails" + id_ordetails, quantity, product));
                id_ordetails++;
//                Orders orders = new Orders();
//                orders.setOrderDetails(orderDetails);

                httpSession.setAttribute("orders", orderDetails);
            } else {
                List<OrderDetails> orderDetailsList = (List<OrderDetails>) httpSession.getAttribute("orders");
                int index = isExists(id_Product, orderDetailsList);
                if (index == -1) {
                    Products products = productService.getProductById(id_Product);
                    orderDetailsList.add(new OrderDetails("SapoOrderDetails" + id_ordetails, quantity, products));
                    id_ordetails++;
                } else {
                    int quantityAfter = orderDetailsList.get(index).getAmount() + 1;
                    orderDetailsList.get(index).setAmount(quantityAfter);
                }
                httpSession.setAttribute("orders", orderDetailsList);
            }
        }
        return "redirect:/list-orders";
    }

    private int isExists(String id, List<OrderDetails> orderDetailsList) {
        for (int i = 0; i < orderDetailsList.size(); i++) {
            if ((orderDetailsList.get(i).getProducts().getId()).equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeOrderWithID(@PathVariable("id") String id, HttpSession httpSession) {
        List<OrderDetails> orderDetailsList = (List<OrderDetails>) httpSession.getAttribute("orders");
        int index = isExists(id, orderDetailsList);
        orderDetailsList.remove(index);
        httpSession.setAttribute("orders", orderDetailsList);
        return "redirect:/list-orders";
    }


    @RequestMapping(value = "/pay-order", method = RequestMethod.POST)
    private String paymentOrder(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        List<OrderDetails> orderDetailsList = (List<OrderDetails>) httpSession.getAttribute("orders");
        String[] amountWithId = httpServletRequest.getParameterValues("amount");
        Integer amount = 0;
        Double price = 0.0;
        Date date = new Date();
        Orders orders = new Orders();
        orders.setId("SapoOrder" + (id));
        for (int i = 0; i < orderDetailsList.size(); i++) {
            orderDetailsList.get(i).setAmount(Integer.parseInt(amountWithId[i]));
            amount += Integer.parseInt(amountWithId[i]);
            price += (orderDetailsList.get(i).getProducts().getSalePrice()) * Integer.parseInt(amountWithId[i]);
            Integer inventory = storeHouseService.findStoreHouseByIdProduct(orderDetailsList.get(i).getProducts().getId()).getInventory()
                    - Integer.parseInt(amountWithId[i]);
            StoreHouse storeHouse = storeHouseService.findStoreHouseByIdProduct(orderDetailsList.get(i).getProducts().getId());
            storeHouse.setInventory(inventory);
            storeHouseService.saveStoreHouse(storeHouse);
            orderDetailsList.get(i).setOrders(orders);
        }

        orders.setOrderDetails(orderDetailsList);
        orders.setTotalPrice(price);
        orders.setAmount(amount);
        orders.setDate(date.toString());
        orders.setPay(httpServletRequest.getParameter("pay"));
        orders.setShip(httpServletRequest.getParameter("ship"));
        String nameCustomer = httpServletRequest.getParameter("NameCustomer");
        Integer phoneCustomer = Integer.parseInt(httpServletRequest.getParameter("PhoneCustomer"));
        String addCustomer = httpServletRequest.getParameter("AddressCustomer");
        Customer customer = new Customer("SaPoCustomer" + idCustomer, nameCustomer, phoneCustomer, addCustomer, orders);
        orders.setCustomer(customer);

        ordersService.saveOrders(orders);
        id++;
        idCustomer++;
        httpSession.removeAttribute("orders");
        return "redirect:/orders";
    }


    private Double total(HttpSession httpSession) {
        List<OrderDetails> orderDetailsList = (List<OrderDetails>) httpSession.getAttribute("orders");
        Double sum = 0.0;
        for (int i = 0; i < orderDetailsList.size(); i++) {
            sum += (orderDetailsList.get(i).getAmount()) * (orderDetailsList.get(i).getProducts().getSalePrice());
        }
        return sum;
    }


    @RequestMapping(value = "/orderDetails/{id}")
    public String orderDetailsWithId(@PathVariable("id") String id, Model model) {
        List<OrderDetails> orderDetailsList = ordersDetailsService.findAllOrderDetailsWithID(id);
        System.out.println(orderDetailsList.size());
        for (int i = 0; i < orderDetailsList.size(); i++) {
            System.out.println(orderDetailsList.get(i).getAmount());
        }
        model.addAttribute("orderDetails", orderDetailsList);
        return "orderDetailsWithId";
    }
}
