package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import t1708m.fashion.Specification.ProductSpecification;
import t1708m.fashion.Specification.SearchCriteria;
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Article;
import t1708m.fashion.entity.ArticleCategory;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.AccountRepository;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.repository.ProductRepository;
import t1708m.fashion.service.BlogService;
import t1708m.fashion.service.ProductService;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "/")
public class HomeController extends ArticleCategory {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public String category(
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "12") int limit,
            Model model, @RequestParam(defaultValue = "") String productName) {
        Specification specification = Specification.where(null);

        if (categoryId != null && categoryId > 0) {
            specification = specification
                    .and(new ProductSpecification(new SearchCriteria("categoryId", "joinProductCategory", categoryId)));
            model.addAttribute("categoryId", categoryId);
        }

        if (keyword != null && keyword.length() > 0) {
            specification = specification
                    .and(new ProductSpecification(new SearchCriteria("keyword", "join", keyword)));
            model.addAttribute("keyword", keyword);
        }
        Page<Product> productPage = productService.findAllActive(specification, PageRequest.of(page - 1, limit));
        List<Article> blog = blogService.blog();
        model.addAttribute("blogs", blog);
        model.addAttribute("list", productPage.getContent());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("currentPage", productPage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", productPage.getPageable().getPageSize());
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "/client/home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CategoryRepository categoryRepository;



}
