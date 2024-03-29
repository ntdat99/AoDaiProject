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
import t1708m.fashion.entity.Account;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.AccountRepository;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.repository.ProductRepository;
import t1708m.fashion.service.AccountServiceImplement;
import t1708m.fashion.service.CategoryService;
import t1708m.fashion.service.ProductService;


import java.util.Calendar;
import java.util.List;

@Controller("adminProductController")
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @RequestMapping(method = RequestMethod.GET)
    public String category(
            @RequestParam(name = "categoryId", required = false) Long categoryId,
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "1") int page,
        @RequestParam(name = "limit", defaultValue = "12") int limit,
        Model model) {
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

        model.addAttribute("list", productPage.getContent());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("currentPage", productPage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", productPage.getPageable().getPageSize());
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "/client/product";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/details/{id}")
    public String category(
            @PathVariable int id,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "4") int limit,
            Model model) {
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        Specification specification = Specification.where(null);
        Page<Product> productPage = productService.findAllActive(specification, PageRequest.of(page - 1, limit));

        model.addAttribute("lists", productPage.getContent());
        model.addAttribute("productdetail", product);
        model.addAttribute("sizes", Product.Size.values());
        model.addAttribute("currentPage", productPage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", productPage.getPageable().getPageSize());
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "/client/product-detail";
    }



    public Account update(Account accountToUpdate){
        accountToUpdate.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return accountRepository.save(accountToUpdate);
    }
}
