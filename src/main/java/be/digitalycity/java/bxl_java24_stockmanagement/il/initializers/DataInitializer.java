package be.digitalycity.java.bxl_java24_stockmanagement.il.initializers;

import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.ArticleRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.CategoryRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.StockMovementRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.StockRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Category;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.StockMovement;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.enums.StockMovementType;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.enums.VAT;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StockRepository stockRepository;
    private final StockMovementRepository movementRepository;

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {
            List<Category> categories = List.of(
                    new Category(UUID.randomUUID(), "Jeux vidéo"),
                    new Category(UUID.randomUUID(), "Livres"),
                    new Category(UUID.randomUUID(), "Films")
            );
            categoryRepository.saveAll(categories);
        }

        if (articleRepository.count() == 0) {
            List<Category> categories = categoryRepository.findAll();
            List<Article> articles = List.of(
                    new Article(
                            UUID.randomUUID(),
                            "Dragon ball sparkling zero",
                            5000L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Jeux vidéo")).findFirst().orElseThrow()
                    ),
                    new Article(
                            UUID.randomUUID(),
                            "Sun Tzu, L'art de la guèrre",
                            500L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Livres")).findFirst().orElseThrow()
                    ),
                    new Article(
                            UUID.randomUUID(),
                            "Le dernier samurai",
                            300L,
                            VAT.TWENTY_ONE,
                            null,
                            categories.stream().filter(
                                    c -> c.getDesignation().equals("Films")).findFirst().orElseThrow()
                    )
            );
            articleRepository.saveAll(articles);
        }

        if (movementRepository.count() == 0) {

            List<Article> articles = articleRepository.findAll();

            List<StockMovement> movements = List.of(
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            10,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Dragon ball sparkling zero")).findFirst().orElseThrow()
                    ),
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            20,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Sun Tzu, L'art de la guèrre")).findFirst().orElseThrow()
                    ),
                    new StockMovement(
                            UUID.randomUUID(),
                            StockMovementType.STOCK_IN,
                            50,
                            LocalDateTime.now(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Le dernier samurai")).findFirst().orElseThrow()
                    )
            );

            List<Stock> stocks = List.of(
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(0).getQuantity(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Dragon ball sparkling zero")).findFirst().orElseThrow()
                    ),
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(1).getQuantity(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Sun Tzu, L'art de la guèrre")).findFirst().orElseThrow()
                    ),
                    new Stock(
                            UUID.randomUUID(),
                            movements.get(2).getQuantity(),
                            articles.stream().filter(
                                    a -> a.getDesignation().equals("Le dernier samurai")).findFirst().orElseThrow()
                    )
            );

            movementRepository.saveAll(movements);
            stockRepository.saveAll(stocks);
        }
    }
}
