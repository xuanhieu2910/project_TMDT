package xuanhieu.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.com.project.dao.OrdersDao;
import xuanhieu.com.project.model.Orders;
import xuanhieu.com.project.service.OrdersService;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersDao ordersDao;

    @Override
    public String saveOrders(Orders orders) {
        ordersDao.saveOrder(orders);
        return "Thêm thành công" ;
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersDao.listAllOrder();
    }
}
