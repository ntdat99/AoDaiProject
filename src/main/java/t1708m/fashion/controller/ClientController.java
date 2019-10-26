package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Account;
import t1708m.fashion.repository.ProductRepository;

@Controller
@RequestMapping(value = "/")
public class ClientController {

    @Autowired(required = false)
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getClient() {
        return "client/index";
    }

    @RequestMapping(method = RequestMethod.GET , value = "/login")
    public String login() {
        return "client/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginFrom(Model model, @RequestBody Account account){



        return "redirect:/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public String getList(Model model) {
        model.addAttribute("list", productRepository.findAll());
        return "client/product";
    }
}
