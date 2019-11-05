package t1708m.fashion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import t1708m.fashion.entity.Article;
import t1708m.fashion.repository.ArticleRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public List<Article> articles() {
        //heroRepository.findAll(PageRequest.of(1, 3));
        return articleRepository.findActiveArticle(1);
    }

    public Page<Article> products(Specification specification, int page, int limit) {
        return articleRepository.findAll(specification, PageRequest.of(page - 1, limit));
    }

    public Article getById(int id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(Article article) {
        article.setStatus(1);
        article.setCreatedAt(Calendar.getInstance().getTimeInMillis());

        return articleRepository.save(article);
    }

    public Article update(Article article) {
        article.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        return articleRepository.save(article);
    }

    public boolean delete(Article article) {

        article.setStatus(-1);
        articleRepository.save(article);
        return true;
    }
}
