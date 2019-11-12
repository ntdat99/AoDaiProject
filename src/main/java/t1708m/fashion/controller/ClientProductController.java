package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.ProductService;

import javax.swing.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ClientProductController {

    @Autowired
    ProductService productService;

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
