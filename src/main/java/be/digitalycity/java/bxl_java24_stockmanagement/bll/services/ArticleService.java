package be.digitalycity.java.bxl_java24_stockmanagement.bll.services;

import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ArticleService {

    Article getById(UUID id);
}
