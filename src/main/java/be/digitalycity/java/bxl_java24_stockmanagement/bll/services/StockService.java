package be.digitalycity.java.bxl_java24_stockmanagement.bll.services;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StockService {

    List<Stock> getStocks();
    Stock getStockByArticleId(UUID articleId);
}
