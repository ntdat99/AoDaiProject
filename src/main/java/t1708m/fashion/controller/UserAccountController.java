package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import t1708m.fashion.entity.Account;
import t1708m.fashion.service.AccountService;
import t1708m.fashion.service.AccountServiceImplement;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account")
public class UserAccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AccountServiceImplement accountServiceImplement;

    @GetMapping(value = "/detail/{email}")
    public String detail(@PathVariable String email, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Account account = accountService.findByEmail(email);
        model.addAttribute("userAccount", account);
        return "client/user-detail";
    }

    @GetMapping(value = "/edit/{email}")
    public String edit(@PathVariable String email, Model model) {
        Account accountToEdit = accountService.findByEmail(email);
        if (accountToEdit == null) {
            return "Error";
        }
        model.addAttribute("account", accountToEdit);
        return "client/user-edit";
    }

    @PostMapping(value = "/edit/{email}")
    public String update(@PathVariable String email, Model model, Account accountToUpdate) {
        Account account = accountService.findByEmail(email);
        account.setUsername(accountToUpdate.getUsername());
        account.setPhone(accountToUpdate.getPhone());
        account.setAddress(accountToUpdate.getAddress());
        accountService.update(account);
        model.addAttribute("account", account);
        return "redirect:/";
    }

    @GetMapping(value = "/changePassword1")
    public String checkOldPassword(@RequestParam(name = "password", required = false) String password,
                                        @AuthenticationPrincipal UserDetails userAccount) {
        String accountPassword = accountService.findByEmail(userAccount.getUsername()).getPassword();


        if(password != null && passwordEncoder.matches(password, accountPassword)) {
            System.out.print("Password la:" + password);
            return "redirect:/account/changePassword2";
        } else {
            return "client/change-password1";
        }
    }

    @GetMapping(value = "/changePassword2")
    public String enterNewPwd(Model model,
                           @AuthenticationPrincipal UserDetails userAccount) {
        Account account = accountServiceImplement.findByEmail(userAccount.getUsername());
        if(account == null) {
            return "error/404";
        }
        model.addAttribute("account", account);
        return "client/change-password2";
    }

    @PostMapping(value = "/changePassword2")
    public String ChangePassword(Account accountToUpdatePwd, @AuthenticationPrincipal UserDetails userAccount) {
        Account account = accountServiceImplement.findByEmail(userAccount.getUsername());
        account.setPassword(passwordEncoder.encode(accountToUpdatePwd.getPassword()));
        accountService.update(account);
        return "redirect:/login";
    }
}
