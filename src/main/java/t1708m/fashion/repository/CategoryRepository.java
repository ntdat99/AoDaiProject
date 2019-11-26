package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import t1708m.fashion.entity.ProductCategory;

import java.util.List;


public interface CategoryRepository extends JpaRepository<ProductCategory, Long>, JpaSpecificationExecutor<ProductCategory> {

    @Query("select h from ProductCategory as h where h.status = :status")
    List<ProductCategory> findActiveCategory(@Param("status") int status);

    List<ProductCategory> findAll();

    List<ProductCategory> findAllByStatus(int status);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SET FOREIGN_KEY_CHECKS=1;")
    void enableForeignKeyCheck();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SET FOREIGN_KEY_CHECKS=0;")
    void disableForeignKeyCheck();


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table product_category AUTO_INCREMENT = 1")
    void resetIncrement();

}
