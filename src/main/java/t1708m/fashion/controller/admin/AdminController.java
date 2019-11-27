package t1708m.fashion.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Account;
import t1708m.fashion.service.AccountService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAdmin(@AuthenticationPrincipal UserDetails userDetails) {
        Account accountToCheck = accountService.findByEmail(userDetails.getUsername());
        int role = accountToCheck.getRole();
        if(role == 99)
            return "admin/index";
        else {
            return "redirect:/login";
        }
    }
    //product
    @GetMapping(value = "/list-product")
    public String product() {
        return "/admin/product/index";
    }
    @GetMapping(value = "/create-product")
    public String Creproduct() {
        return "/admin/product/form";
    }
   //account
    @GetMapping("/account-edit")
    public String edit() {
        return "/admin/account/edit";
    }
    @GetMapping("/account-list")
    public String list() {
        return "/admin/account/list";
    }
    @GetMapping("/account-create")
    public String create() {
        return "/admin/account/create";
    }
//    category
    @GetMapping(value = "/list-category")
    public String category() {
        return "/admin/category/index";
    }
    @GetMapping(value = "/create-category")
    public String Crecategory() {
        return "/admin/category/form";
    }
    //blog
    @GetMapping(value = "/list-blog")
    public String blog() {
        return "/admin/blog/index";
    }
    @GetMapping(value = "/create-blog")
    public String CreateBlog() {
        return "/admin/blog/form";
    }
}
