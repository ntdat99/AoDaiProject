package t1708m.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708m.fashion.Specification.ProductSpecification;
import t1708m.fashion.Specification.SearchCriteria;
import t1708m.fashion.entity.Article;
import t1708m.fashion.entity.Product;
import t1708m.fashion.repository.BlogRepository;
import java.util.Calendar;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<Article> blog() {
        return blogRepository.findActiveBlog(1);
    }

    public Page<Article> articles(Specification specification, Pageable pageable) {
        return blogRepository.findAll(specification,pageable);
    }


    public Article getById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public Article create(Article blog) {
        blog.setCreatedBy(blog.getCreatedBy());
        blog.setUpdatedBy(blog.getUpdatedBy());
        blog.setUpdateAt(Calendar.getInstance().getTimeInMillis());
        blog.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        return blogRepository.save(blog);
    }

    public Article update(Article blog) {
        blog.setUpdateAt(Calendar.getInstance().getTimeInMillis());
        blog.setStatus(1);
        return blogRepository.save(blog);
    }

    public boolean delete(Article blog) {
        blog.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        blog.setStatus(-1);
        blogRepository.save(blog);
        return true;
    }
}
