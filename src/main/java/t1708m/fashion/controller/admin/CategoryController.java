package t1708m.fashion.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import t1708m.fashion.entity.Product;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.service.CategoryService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "2") int limit,
            Model model) {
        Page<ProductCategory> productCategoryPage = categoryRepository.findAll(PageRequest.of(page - 1, limit));
        model.addAttribute("category", productCategoryPage.getContent());
        model.addAttribute("currentPage", productCategoryPage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", productCategoryPage.getPageable().getPageSize());
        model.addAttribute("totalPage", productCategoryPage.getTotalPages());
        return "admin/category/index";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        model.addAttribute("category", category);
        return "admin/category/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("category", new ProductCategory());
        return "admin/category/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid ProductCategory category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            return "admin/category/form";
        }
        categoryService.create(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, ProductCategory updateCategory) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        category.setName(updateCategory.getName());
        category.setPrice(updateCategory.getPrice());
        category.setDescription(updateCategory.getDescription());
        category.setImage(updateCategory.getImage());
        categoryService.update(category);
        return "redirect:/admin/category";
    }

    //    // viết ajax call.
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    @ResponseBody
//    public ResponseEntity<Object> update(@PathVariable int id) {
//        HashMap<String, Object> mapResponse = new HashMap<>();
//        ProductCategory category = categoryService.getById(id);
//        if (category == null) {
//            mapResponse.put("status", HttpStatus.NOT_FOUND.value());
//            mapResponse.put("message", "product Category is not found!");
//            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
//        }
//        categoryService.delete(category);
//        mapResponse.put("status", HttpStatus.OK.value());
//        mapResponse.put("message", "Delete success");
//        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
//    }
    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String delete(@PathVariable int id, ProductCategory delProCa) {
        ProductCategory productCategory = categoryService.getById(id);
        if (productCategory == null) {
            return "error/404";
        }
        productCategory.setStatus(-1);
        categoryService.delete(productCategory);
        return "redirect:/admin/category";
    }
}
