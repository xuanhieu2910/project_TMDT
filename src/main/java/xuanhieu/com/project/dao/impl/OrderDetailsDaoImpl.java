package xuanhieu.com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.com.project.dao.OrderDetailsDao;
import xuanhieu.com.project.model.OrderDetails;
import xuanhieu.com.project.repository.OrderDetailsRepository;

import java.util.List;
@Repository
public class OrderDetailsDaoImpl  implements OrderDetailsDao {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> getAllById(String id) {
        return orderDetailsRepository.getAllById(id);
    }
}
