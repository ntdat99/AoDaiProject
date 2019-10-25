package t1708m.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import t1708m.fashion.entity.Category;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.CategoryRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> categories() {
        categoryRepository.findAll(PageRequest.of(1, 3));
        return categoryRepository.findActiveCategory(1);
    }
    public Category getById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public Category create(Category category) {
        category.setStatus(1);
        category.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        category.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return categoryRepository.save(category);
    }
    public Category update(Category category) {
        category.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return categoryRepository.save(category);
    }

    public boolean delete(Category category) {
        category.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        category.setStatus(-1);
        categoryRepository.save(category);
        return true;
    }
}
