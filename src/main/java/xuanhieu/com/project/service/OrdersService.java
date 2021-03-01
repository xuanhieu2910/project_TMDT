package xuanhieu.com.project.service;

import xuanhieu.com.project.model.Orders;
import java.util.*;
public interface OrdersService {

    String saveOrders(Orders orders);

    List<Orders>findAllOrders();
}
