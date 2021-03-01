package xuanhieu.com.project.service;
import xuanhieu.com.project.model.OrderDetails;

import java.util.*;
public interface OrdersDetailsService {

    List<OrderDetails>findAllOrderDetailsWithID(String id);

}
