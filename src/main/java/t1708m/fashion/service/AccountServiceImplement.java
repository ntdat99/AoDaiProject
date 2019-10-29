package t1708m.fashion.service;

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
import t1708m.fashion.repository.AccountRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AccountServiceImplement  implements AccountService {

    @Autowired
    AccountRepository accountRepository;



    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Account findByEmail(String email){
        return accountRepository.findByEmail(email);
    }

    public Account save(AccountDTO register){
        Account account = new Account();
        account.setUsername(register.getUsername());
        account.setEmail(register.getEmail());
        account.setPassword(passwordEncoder.encode(register.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if (account == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
//        return new org.springframework.security.core.userdetails.User(account.getEmail(),
//                account.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));
        UserDetails user =
                User.builder()
                        .username(account.getEmail())
                        .password(account.getPassword())
                        .roles("USER")
                        .build();
        return user;
    }


}