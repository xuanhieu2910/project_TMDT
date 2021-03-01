package xuanhieu.com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.com.project.dao.StoreHouseDao;
import xuanhieu.com.project.model.StoreHouse;
import xuanhieu.com.project.repository.StoreHouseRepository;

import java.util.List;

@Repository
public class StoreHouseDaoImpl implements StoreHouseDao {

    @Autowired
    StoreHouseRepository storeHouseRepository;

    @Override
    public String saveStoreHouse(StoreHouse storeHouse) {
        storeHouseRepository.save(storeHouse);
        return "Cập nhập nhà kho thành công!";
    }

    @Override
    public void deleteProductInStoreHouseById(String id) {
        storeHouseRepository.deleteById(id);
    }

    @Override
    public List<StoreHouse> allStoreHouse() {
        return storeHouseRepository.findAll();
    }

    @Override
    public StoreHouse findProductById(String id) {
        return storeHouseRepository.findProductById(id);
    }

}
