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
import t1708m.fashion.entity.Article;
import t1708m.fashion.service.ArticleService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/articles")
public class ArticleController {
@Autowired
    ArticleService articleService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Article> articles = articleService.articles();
        model.addAttribute("articles", articles);
        return "article/index";
    }

}
