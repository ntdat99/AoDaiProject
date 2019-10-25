package t1708m.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import t1708m.fashion.DTO.CategoryDTO;

import t1708m.fashion.REST.RESTResponse;
import t1708m.fashion.entity.Category;

import t1708m.fashion.service.CategoryService;

@Controller
@RequestMapping(value = "/admin/aodai/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Category category) {
        // validate.
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Action Success")
                .addData(new CategoryDTO(categoryService.create(category)))
                .build(),
                HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Category updateCategory) {
        Category existCategory = categoryService.getById(id);
        if (existCategory == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not found")
                    .build(),
                    HttpStatus.NOT_FOUND);
        }
        existCategory.setName(updateCategory.getName());
        existCategory.setImage(updateCategory.getImage());
        existCategory.setGender(updateCategory.getGender());
        existCategory.setPrice(updateCategory.getPrice());

        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success")
                .addData(new CategoryDTO(categoryService.update(existCategory)))
                .build(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        Category existCategory = categoryService.getById(id);
        if (existCategory == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not found")
                    .build(),
                    HttpStatus.NOT_FOUND);
        }
        categoryService.delete(existCategory);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Simple Success")
                .build(),
                HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            return new ResponseEntity<>(new RESTResponse.SimpleError()
                    .setCode(HttpStatus.NOT_FOUND.value())
                    .setMessage("Not found")
                    .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success")
                .addData(new CategoryDTO(categoryService.getById(id)))
                .build(),
                HttpStatus.OK);
    }

}
