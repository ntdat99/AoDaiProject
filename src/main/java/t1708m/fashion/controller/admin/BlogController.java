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
import t1708m.fashion.entity.Article;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.BlogRepository;
import t1708m.fashion.service.BlogService;
import javax.validation.Valid;
import java.util.HashMap;

@Controller("customerBlogController")
@RequestMapping(value = "/admin/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String list(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "1") int limit,
            Model model) {
        Page<Article> articlePage = blogRepository.findAll(PageRequest.of(page - 1, limit));
        model.addAttribute("blog", articlePage.getContent());
        model.addAttribute("currentPage", articlePage.getPageable().getPageNumber() + 1);
        model.addAttribute("limit", articlePage.getPageable().getPageSize());
        model.addAttribute("totalPage", articlePage.getTotalPages());
        return "admin/blog/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String detail(@PathVariable int id, Model model) {
        Article blog = blogService.getById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("status",Article.Status.values());
        return "admin/blog/detail";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("blog", new Article());
        return "/admin/blog/form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Model model, @Valid Article blog, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("blog", blog);
            return "/admin/blog/form";
        }
        blog.setStatus(Article.Status.ACTIVE.getValue());
        blogService.create(blog);
        return "redirect:/admin/blogs";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Article blog = blogService.getById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        return "admin/blog/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/{id}")
    public String update(@PathVariable int id, Model model, Article updateBlog) {
        Article blog = blogService.getById(id);
        if (blog == null) {
            return "error/404";
        }
        model.addAttribute("blog", blog);
        blog.setTitle(updateBlog.getTitle());
        blog.setDescription(updateBlog.getDescription());
        blog.setDescription(updateBlog.getDescription());
        blog.setContent(updateBlog.getContent());
        blog.setThumbnail(updateBlog.getThumbnail());
        blog.setUpdateAt(updateBlog.getUpdateAt());
        blog.setDeletedAt(updateBlog.getDeletedAt());
        blog.setCategory(updateBlog.getCategory());
        blog.setStatus(updateBlog.getStatus());
        return "redirect:/admin/blogs";
    }

    // viết ajax call.
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseBody
    public ResponseEntity<Object> delete(@PathVariable int id) {
        HashMap<String, Object> mapResponse = new HashMap<>();
        Article blog = blogService.getById(id);
        if (blog == null) {
            mapResponse.put("status", HttpStatus.NOT_FOUND.value());
            mapResponse.put("message", "Blog is not found!");
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
        blogService.delete(blog);
        mapResponse.put("status", HttpStatus.OK.value());
        mapResponse.put("message", "Delete success");
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
