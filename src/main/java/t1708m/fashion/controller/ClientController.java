package t1708m.fashion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class ClientController {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String Index() {
        return "index";
    }
}
