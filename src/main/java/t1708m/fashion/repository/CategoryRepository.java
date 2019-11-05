package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t1708m.fashion.entity.Category;
import t1708m.fashion.entity.Product;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

    @Query("select h from Category as h where h.status = :status")
    List<Category> findActiveCategory(@Param("status") int status);

    List<Category> findAllByStatus(int status);
}
