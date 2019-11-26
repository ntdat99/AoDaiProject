package t1708m.fashion.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708m.fashion.Specification.ProductSpecification;
import t1708m.fashion.Specification.SearchCriteria;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Calendar;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> products() {
        return productRepository.findActiveProduct(1);
    }

    public List<Product> getByName(String name) {
        return productRepository.findAllByName(name);
    }

    public Page<Product> products(Specification specification, int page, int limit) {
        return productRepository.findAll(specification, PageRequest.of(page - 1, limit));
    }
    public Page<Product> findAllActive(Specification specification, Pageable pageable) {

        specification = specification
                .and(new ProductSpecification(new SearchCriteria("status", "!=", Product.Status.DELETED.getValue())));
        System.out.println(specification);
        return productRepository.findAll(specification, pageable);
    }
    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product create(Product product) {
        product.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }
    public Product update(Product product) {
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        product.setName(product.getName());
        product.setStatus(1);
        return productRepository.save(product);
    }

    public boolean delete(Product product) {
        product.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        product.setStatus(-1);
        productRepository.save(product);
        return true;
    }


}
