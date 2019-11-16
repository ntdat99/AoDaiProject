package t1708m.fashion.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.DTO.AccountDTO;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.AccountService;
import t1708m.fashion.service.AccountServiceImplement;
import t1708m.fashion.service.ProductService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value = "/admin/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountServiceImplement accountServiceImplement;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Account> accounts = accountServiceImplement.findAccounts();
        model.addAttribute("accounts", accounts);
        return "admin/account/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("account", new AccountDTO());
        return "/admin/account/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid AccountDTO account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("accounts", account);
            return "/admin/account/create";
        }
        accountServiceImplement.save(account);
        return "redirect:/admin/account";
    }
}
