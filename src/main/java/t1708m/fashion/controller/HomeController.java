package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.ArticleCategory;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.AccountRepository;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.service.ProductService;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/")
public class HomeController extends ArticleCategory {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> products = productService.products();
        model.addAttribute("products", products);
        return "/client/home";
    }
    @GetMapping("/contact")
    public String contact() {
        return "client/contact";
    }
    @GetMapping("/about")
    public String blog() {
        return "client/about";
    }
    @GetMapping("/blog-detail")
    public String blogDetail() {
        return "client/blog-detail";
    }
    @GetMapping("/home-03")
    public String home3() {
        return "client/home-03";
    }
    @GetMapping("/home-02")
    public String home2() {
        return "client/home-02";
    }

    @GetMapping("/shoping-cart")
    public String shoppingCart() {
        return "client/shoping-cart";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CategoryRepository categoryRepository;


//    @GetMapping("/seed/account")
//    public String account(){
//        Random random = new Random();
//        List<String> names = Arrays.asList("khoa","phuc","hoang anh","long","dat");
//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
//        List<Integer> roleNumbers = Arrays.asList(1,99);
//        List<Integer> statusNumbers = Arrays.asList(-1,1,2);
//        for (int i =0; i<=15 ;i++){
//            Account account = new Account();
//            account.setAddress("ha noi");
//            account.setEmail(names.get(random.nextInt(names.size())) + numbers.get(random.nextInt(numbers.size())));
//            account.setPassword(passwordEncoder.encode("123"));
//            account.setPhone("097547541");
//            account.setRole(roleNumbers.get(random.nextInt(roleNumbers.size())));
//            account.setStatus(statusNumbers.get(random.nextInt(statusNumbers.size())));
//            account.setUsername(names.get(random.nextInt(names.size())));
//            accountRepository.save(account);
//        }
//        return "seed/seed";
//
//    }

}
