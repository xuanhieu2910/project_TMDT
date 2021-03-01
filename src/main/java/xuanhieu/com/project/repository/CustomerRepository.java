package xuanhieu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.com.project.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
