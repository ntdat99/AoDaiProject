package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.ProductService;

import java.util.List;

@Controller("adminProductController")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Product> products = productService.products();
        model.addAttribute("customer", products);
        return "/client/product";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        model.addAttribute("productdetail", product);
        return "client/product-detail";
    }


}
