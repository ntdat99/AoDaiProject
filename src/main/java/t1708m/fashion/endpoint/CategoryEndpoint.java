package t1708m.fashion.endpoint;

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
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.CategoryRepository;
import t1708m.fashion.service.CategoryService;
import t1708m.fashion.service.ProductService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/productcategories")
public class CategoryEndpoint {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<ProductCategory> productcategories= categoryService.categories();
        model.addAttribute("categories", productcategories);
        return "admin/productcategory/index";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        model.addAttribute("category", category);
        return "admin/productcategory/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("category", new ProductCategory());
        return "admin/productcategory/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid ProductCategory category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            return "admin/productcategory/form";
        }
        categoryService.create(category);
        return "redirect:/productcategories";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        model.addAttribute("category", category);
        return "admin/productcategory/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, ProductCategory updateCategory) {
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            return "error/404";
        }
        category.setName(updateCategory.getName());
        category.setPrice(updateCategory.getPrice());

        categoryService.update(category);
        return "redirect:/productcategories";
    }

    // viết ajax call.
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public ResponseEntity<Object> update(@PathVariable int id) {
        HashMap<String, Object> mapResponse = new HashMap<>();
        ProductCategory category = categoryService.getById(id);
        if (category == null) {
            mapResponse.put("status", HttpStatus.NOT_FOUND.value());
            mapResponse.put("message", "product Category is not found!");
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
        categoryService.delete(category);
        mapResponse.put("status", HttpStatus.OK.value());
        mapResponse.put("message", "Delete success");
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
