package xuanhieu.com.project.dao;

import xuanhieu.com.project.model.StoreHouse;
import java.util.*;
public interface StoreHouseDao {

    String saveStoreHouse(StoreHouse storeHouse);


    void deleteProductInStoreHouseById(String id);

    List<StoreHouse>allStoreHouse();

    StoreHouse findProductById(String id);
}
