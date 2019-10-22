package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/aodai")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("product", productService.getList(1, 10));
        return "admin/aodai/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getDetail(id));
        return "admin/aodai/detail";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "admin/aodai/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String store(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/aodai/form";
        }
        productService.create(product);
        return "redirect:/admin/aodai";
    }
}
