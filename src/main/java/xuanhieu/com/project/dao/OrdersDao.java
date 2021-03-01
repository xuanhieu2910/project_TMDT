package xuanhieu.com.project.dao;
import java.util.*;
import xuanhieu.com.project.model.Orders;

public interface OrdersDao {

    String saveOrder(Orders orders);


    List<Orders>listAllOrder();
}
