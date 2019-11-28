package t1708m.fashion.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import t1708m.fashion.Specification.ProductSpecification;
import t1708m.fashion.Specification.SearchCriteria;
import t1708m.fashion.entity.Article;
import t1708m.fashion.entity.Product;
import t1708m.fashion.service.BlogService;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;


    @RequestMapping(method = RequestMethod.GET)
    public String category(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "6") int limit,
            Model model, @RequestParam(defaultValue = "") String articleName) {
        Specification specification = Specification.where(null);


        Page<Article> articlePage = blogService.articles(specification,PageRequest.of(page - 1, limit));

        model.addAttribute("blogs", articlePage);

        model.addAttribute("currentPage", articlePage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", articlePage.getPageable().getPageSize());
        model.addAttribute("totalPage", articlePage.getTotalPages());
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





