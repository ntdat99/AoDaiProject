package t1708m.fashion.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import t1708m.fashion.DTO.AccountDTO;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.AccountRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
            if (account == null) {
                throw new UsernameNotFoundException("Invalid username or password.");
            }
        UserDetails user =
                User.builder()
                        .username(account.getEmail())
                        .password(account.getPassword())
                        .roles(account.getRole() == 1 ? "CUSTOMER" : (account.getRole() == 99 ? "ADMIN" : ""))
                        .build();
        return user;
    }
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
    public Account save(AccountDTO register ) {
        Account account = new Account();
        account.setUsername(register.getUsername());
        account.setEmail(register.getEmail());
        account.setPassword(passwordEncoder.encode(register.getPassword()));
        account.setPhone(register.getPhone());
        account.setAddress(register.getAddress());
        account.setStatus(1);
        account.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        account.setRole(register.getRole());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

}
