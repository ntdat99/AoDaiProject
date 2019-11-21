package t1708m.fashion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.entity.Article;
import t1708m.fashion.service.BlogService;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Article> blog = blogService.blog();
        model.addAttribute("blogs", blog);
        return "/client/blog";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Article blog = blogService.getById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blogdetail", blog);
        return "client/blog-detail";
    }

}





