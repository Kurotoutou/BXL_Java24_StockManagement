package be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {

    @Query("select s from Stock s join s.article where s.article.id = :articleId")
    Optional<Stock> findByArticleId(UUID articleId);
}
