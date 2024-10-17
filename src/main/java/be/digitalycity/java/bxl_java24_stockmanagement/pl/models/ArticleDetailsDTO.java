package be.digitalycity.java.bxl_java24_stockmanagement.pl.models;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.enums.VAT;

import java.util.UUID;

public record ArticleDetailsDTO(
        UUID id,
        String designation,
        double unitPriceExcludingTax,
        double unitPriceIncludingTax,
        double addedValue,
        VAT vat,
        String picture,
        String category,
        int quantity
) {
    public static ArticleDetailsDTO articleDetail(Stock stock) {
        Article a = stock.getArticle();
        return new ArticleDetailsDTO(
                a.getId(),
                a.getDesignation(),
                a.getUnitPriceExcludingTax() / 100D,
                a.getUnitPriceIncludingTax() / 100D,
                a.getAddedValue(),
                a.getVat(),
                a.getPicture(),
                a.getCategory().getDesignation(),
                stock.getCurrentQuantity()

        );
    }
}
