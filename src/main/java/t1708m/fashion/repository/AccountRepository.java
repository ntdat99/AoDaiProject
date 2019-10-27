package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1708m.fashion.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


}
