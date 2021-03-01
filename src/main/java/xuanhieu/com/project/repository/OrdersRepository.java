package xuanhieu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.com.project.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,String> {



}
