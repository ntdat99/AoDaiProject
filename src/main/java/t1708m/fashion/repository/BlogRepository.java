package t1708m.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t1708m.fashion.entity.Article;

import java.util.List;

public interface BlogRepository  extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    @Query("select h from Article as h where h.status = :status")
    List<Article> findActiveBlog(@Param("status") int status);

    List<Article> findAll();

    List<Article> findAllByStatus(int status);
}
