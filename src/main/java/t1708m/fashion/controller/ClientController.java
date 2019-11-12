package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class ClientController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> products = productService.products();
        model.addAttribute("products", products);
        return "/client/home";
    }

    @GetMapping("/product")
    public String product() {
        return "client/product";
    }
    @GetMapping("/contact")
    public String contact() {
        return "client/contact";
    }
    @GetMapping("/about")
    public String about() {
        return "client/about";
    }
    @GetMapping("/blog")
    public String blog() {
        return "client/blog";
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

}
