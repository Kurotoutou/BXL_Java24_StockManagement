package be.digitalycity.java.bxl_java24_stockmanagement.bll.services.impls;

import be.digitalycity.java.bxl_java24_stockmanagement.bll.services.ArticleService;
import be.digitalycity.java.bxl_java24_stockmanagement.dal.repositories.stock.ArticleRepository;
import be.digitalycity.java.bxl_java24_stockmanagement.dl.entities.stock.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article getById(UUID id) {
        return articleRepository.findById(id).orElseThrow();
    }
}
