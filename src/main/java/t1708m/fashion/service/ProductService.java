package t1708m.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import t1708m.fashion.repository.ProductRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product create(Product product) {
        product.setStatus(1);
        product.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        product.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }
    public List<Product> products(){
        return productRepository.findActiveProduct(1);
    }
    public Product getDetail(int id) {
        return productRepository.findById(id).orElse(null);
    }
    public boolean deleted(int id) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct == null) {
            return false;
        }
        productRepository.delete(existProduct);
        return true;
    }
    public Product update(int id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct == null) {
            return null;
        }
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPrice(product.getPrice());
        existProduct.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return productRepository.save(product);
    }
    public Page<Product> getList(int page, int limit) {
        return productRepository.findAll(PageRequest.of(page - 1, limit));
    }
}
