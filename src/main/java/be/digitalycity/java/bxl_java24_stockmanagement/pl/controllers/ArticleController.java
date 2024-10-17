package be.digitalycity.java.bxl_java24_stockmanagement.pl.controllers;

import be.digitalycity.java.bxl_java24_stockmanagement.bll.services.ArticleService;
import be.digitalycity.java.bxl_java24_stockmanagement.bll.services.StockService;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import be.digitalycity.java.bxl_java24_stockmanagement.pl.models.ArticleDTO;
import be.digitalycity.java.bxl_java24_stockmanagement.pl.models.ArticleDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final StockService stockService;
    private final ArticleService articleService;

    @GetMapping
    public String getArticles(Model model) {

        List<ArticleDTO> articles = stockService.getStocks().stream()
                .map(ArticleDTO::fromStock)
                .toList();
        model.addAttribute("articles", articles);
        return "article/index";
    }

    @GetMapping("/{id}")
    public String getArticleDetail(
            @PathVariable
            UUID id,
            Model model
    ) {
        try {
            ArticleDetailsDTO dto = ArticleDetailsDTO.articleDetail(stockService.getStockByArticleId(id));
            model.addAttribute("article", dto);
        } catch (NoSuchElementException e) {
            return "Errore/error404";
        }
        return "article/details";
    }
}
