package xuanhieu.com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.com.project.dao.CustomerDao;
import xuanhieu.com.project.model.Customer;
import xuanhieu.com.project.repository.CustomerRepository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
