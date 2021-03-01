package xuanhieu.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.com.project.dao.StoreHouseDao;

import xuanhieu.com.project.model.StoreHouse;
import xuanhieu.com.project.service.StoreHouseService;

import java.util.List;

@Service
public class StoreHouseServiceImpl implements StoreHouseService{

    @Autowired
    StoreHouseDao storeHouseDao;


    @Override
    public String saveStoreHouse(StoreHouse storeHouse) {
        return storeHouseDao.saveStoreHouse(storeHouse);
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public List<StoreHouse> findAllStoreHouse() {
        return storeHouseDao.allStoreHouse();
    }

    @Override
    public StoreHouse findStoreHouseByIdProduct(String id) {
        return storeHouseDao.findProductById(id);
    }


}
