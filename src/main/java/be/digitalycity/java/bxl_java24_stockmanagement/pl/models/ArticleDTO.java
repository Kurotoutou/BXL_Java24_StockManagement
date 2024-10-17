package be.digitalycity.java.bxl_java24_stockmanagement.pl.models;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;

import java.util.UUID;

public record ArticleDTO(
        UUID id,
        String designation,
        double unitPriceExcludingTax,
        double unitPriceIncludingTax,
        String category,
        int quantity
) {

    public static ArticleDTO fromStock(Stock stock) {
        Article article = stock.getArticle();
        return new ArticleDTO(
                article.getId(),
                article.getDesignation(),
                article.getUnitPriceExcludingTax() / 100D,
                article.getUnitPriceIncludingTax() / 100D,
                article.getPicture(),
                stock.getCurrentQuantity()
        );
    }
}
