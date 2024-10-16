package be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<Article, UUID> {


}
