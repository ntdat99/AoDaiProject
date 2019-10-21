package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

    @Query("select h from Product as h where h.status = :status")
    List<Product> findActiveProduct(@Param("status") int status);

    List<Product> findAllByStatus(int status);
}
