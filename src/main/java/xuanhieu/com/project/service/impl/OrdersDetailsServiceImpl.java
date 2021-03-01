package xuanhieu.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.com.project.dao.OrderDetailsDao;
import xuanhieu.com.project.model.OrderDetails;
import xuanhieu.com.project.service.OrdersDetailsService;

import java.util.List;
@Service
public class OrdersDetailsServiceImpl implements OrdersDetailsService {

    @Autowired
    OrderDetailsDao orderDetailsDao;


    @Override
    public List<OrderDetails> findAllOrderDetailsWithID(String id) {
        return orderDetailsDao.getAllById(id);
    }
}
