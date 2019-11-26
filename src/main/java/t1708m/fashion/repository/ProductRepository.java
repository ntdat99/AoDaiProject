package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import t1708m.fashion.entity.Product;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select h from Product as h where h.status = :status")
    List<Product> findActiveProduct(@Param("status") int status);

    List<Product> findAll();

    @Query("SELECT p FROM Product as p WHERE p.name LIKE CONCAT('%',:name,'%')")
    List<Product> findAllByName (String name);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SET FOREIGN_KEY_CHECKS=0;")
    void disableForeignKeyCheck();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SET FOREIGN_KEY_CHECKS=1;")
    void enableForeignKeyCheck();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "alter table product AUTO_INCREMENT = 1")
    void resetIncrement();

}
