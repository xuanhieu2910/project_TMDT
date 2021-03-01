package xuanhieu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import xuanhieu.com.project.model.Products;

public interface ProductsRepository  extends JpaRepository<Products,String> {

    @Query("SELECT pr FROM Products pr where pr.id=:id")
    Products getProductById(@Param("id")String id);

}
