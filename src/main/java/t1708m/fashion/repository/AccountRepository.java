package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmail (String email);

    List<Account> findAll();

}
