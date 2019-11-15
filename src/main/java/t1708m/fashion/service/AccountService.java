package t1708m.fashion.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import t1708m.fashion.DTO.AccountDTO;
import t1708m.fashion.entity.Account;

import java.util.List;


public interface AccountService extends UserDetailsService {
    Account findByEmail(String email);

    Account save(AccountDTO register);

    List<Account> findAccounts();
}
