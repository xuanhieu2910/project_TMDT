package xuanhieu.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.com.project.dao.CustomerDao;
import xuanhieu.com.project.model.Customer;
import xuanhieu.com.project.service.CustomerService;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
