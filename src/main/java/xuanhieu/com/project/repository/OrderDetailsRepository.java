package xuanhieu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xuanhieu.com.project.model.OrderDetails;
import java.util.*;
public interface OrderDetailsRepository  extends JpaRepository<OrderDetails,String> {

    @Query("SELECT od FROM OrderDetails od where od.orders.id=:id")
    List<OrderDetails>getAllById(@Param("id")String id);

}
