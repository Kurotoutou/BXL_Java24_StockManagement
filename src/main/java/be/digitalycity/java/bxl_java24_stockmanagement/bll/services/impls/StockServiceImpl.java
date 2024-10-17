package be.digitalycity.java.bxl_java24_stockmanagement.bll.services.impls;

import be.digitalycity.java.bxl_java24_stockmanagement.bll.services.StockService;
import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.StockRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockByArticleId(UUID articleId) {
        return stockRepository.findByArticleId(articleId).orElseThrow();
    }
}
