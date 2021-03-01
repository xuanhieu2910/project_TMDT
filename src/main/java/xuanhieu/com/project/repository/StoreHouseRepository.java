package xuanhieu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xuanhieu.com.project.model.StoreHouse;
import java.util.*;

public interface StoreHouseRepository extends JpaRepository<StoreHouse,String> {

    @Query("delete from StoreHouse st where st.products=:id")
    void deleteByIdOfProduct(@Param("id")String id);


    @Query("SELECT sh FROM StoreHouse sh where sh.products.id=:id")
    StoreHouse findProductById(@Param("id")String id);

}
