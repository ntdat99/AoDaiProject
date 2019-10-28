package t1708m.fashion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class ClientController {

    @RequestMapping(method = RequestMethod.GET)
    public String getClient() {
        return "client/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
