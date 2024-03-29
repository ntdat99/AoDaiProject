package t1708m.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708m.fashion.entity.ProductCategory;
import t1708m.fashion.repository.CategoryRepository;
import java.util.Calendar;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<ProductCategory> categories() {
        return categoryRepository.findActiveCategory(1);
    }

    public ProductCategory getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Page<ProductCategory> categories(Specification specification, int page, int limit) {
        return categoryRepository.findAll(specification, PageRequest.of(page - 1, limit));
    }
    public ProductCategory create(ProductCategory category) {
        category.setStatus(1);
        category.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        category.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return categoryRepository.save(category);
    }

    public ProductCategory update(ProductCategory category) {
        category.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return categoryRepository.save(category);
    }

    public boolean delete(ProductCategory category) {
        category.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        category.setStatus(-1);
        categoryRepository.save(category);
        return true;
    }
}
