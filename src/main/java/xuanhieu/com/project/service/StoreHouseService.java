package xuanhieu.com.project.service;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.com.project.model.StoreHouse;
import java.util.*;
public interface StoreHouseService {

    String saveStoreHouse(StoreHouse storeHouse);

    void deleteProduct ();

    List<StoreHouse>findAllStoreHouse();

    StoreHouse findStoreHouseByIdProduct(String id);

}
