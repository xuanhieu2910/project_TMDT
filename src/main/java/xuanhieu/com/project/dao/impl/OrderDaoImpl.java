package xuanhieu.com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.com.project.dao.OrdersDao;
import xuanhieu.com.project.model.Orders;
import xuanhieu.com.project.repository.OrdersRepository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrdersDao {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public String saveOrder(Orders orders) {
        ordersRepository.save(orders);
        return "Thêm thành công";
    }

    @Override
    public List<Orders> listAllOrder() {
        return ordersRepository.findAll();
    }
}
