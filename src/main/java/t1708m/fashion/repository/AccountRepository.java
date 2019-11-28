package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Long> {

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
    @Query(nativeQuery = true, value = "alter table account AUTO_INCREMENT = 1")
    void resetIncrement();

    Account findByEmail (String email);

    List<Account> findAll();

    @Query("update Account a set a.password = :password where a.email = :email")
    int updatePassword(@Param("password") String password, @Param("email") String email);
}
