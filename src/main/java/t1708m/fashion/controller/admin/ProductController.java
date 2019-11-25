package t1708m.fashion.controller.admin;

import com.google.gson.Gson;
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
import t1708m.fashion.repository.ProductRepository;
import t1708m.fashion.service.CategoryService;
import t1708m.fashion.service.ProductService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller("customerProductController")
@RequestMapping(value = "/admin/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "1") int limit,
            Model model) {
        Page<Product> productPage = productRepository.findAll(PageRequest.of(page - 1, limit));
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", productPage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", productPage.getPageable().getPageSize());
        model.addAttribute("totalPage", productPage.getTotalPages());
        return "admin/product/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        model.addAttribute("product", product);
        return "admin/product/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        List<ProductCategory> categories = categoryService.categories();
        model.addAttribute("product", new Product());
        model.addAttribute("sizes", Product.Size.values());
        model.addAttribute("genders", Product.Gender.values());
        model.addAttribute("categories", categories);
        return "/admin/product/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("products", product);
            return "/admin/product/form";
        }
        product.setAccountType(Product.AccountType.SHOP.getValue());
        product.setStatus(Product.Status.ACTIVE.getValue());
        productService.create(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        model.addAttribute("product", product);
        model.addAttribute("sizes", Product.Size.values());
        model.addAttribute("genders", Product.Gender.values());
        return "admin/product/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, Product updateProduct) {
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        model.addAttribute("product", product);
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setDescription(updateProduct.getDescription());
        product.setPhotos(updateProduct.getPhotos());
        product.setGender(updateProduct.getGender());
        product.setSize(updateProduct.getSize());
        product.setCategory(updateProduct.getCategory());
        product.setStatus(updateProduct.getStatus());
        productService.update(product);
        return "redirect:/admin/products";
    }

//    // viết ajax call.
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    @ResponseBody
//    public ResponseEntity<Object> delete(@PathVariable int id) {
//        HashMap<String, Object> mapResponse = new HashMap<>();
//        Product product = productService.getById(id);
//        if (product == null) {
//            mapResponse.put("status", HttpStatus.NOT_FOUND.value());
//            mapResponse.put("message", "Product is not found!");
//            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
//        }
//        productService.delete(product);
//        mapResponse.put("status", HttpStatus.OK.value());
//        mapResponse.put("message", "Delete success");
//        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
//    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/ajax-delete/{id}")
//    @ResponseBody
//    public String deleteWithAjax(@PathVariable(value = "id", required = false) long id, HttpServletResponse response) {
//        Product product = productService.getById(id);
//        if (product == null) {
//            response.setStatus(HttpStatus.NOT_FOUND.value());
//            return new Gson().toJson("Error");
//        }
//        productRepository.delete(id);
//        response.setStatus(HttpStatus.OK.value());
//        return new Gson().toJson("Ok");
//    }

    @RequestMapping(method = RequestMethod.GET,value = "/delete/{id}")
    public String delete(@PathVariable int id,Product delPro){
        Product product = productService.getById(id);
        if (product == null) {
            return "error/404";
        }
        product.setStatus(-1);
        productService.delete(product);
        return "redirect:/admin/products";
    }
}
