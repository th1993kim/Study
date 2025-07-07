package kuke.board.article.repository;

import kuke.board.article.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired ArticleRepository articleRepository;


    @Test
    void findAllTest() {
        List<Article> articleList = articleRepository.findAll(1L, 1449998L, 30L);

        log.info("articleSize: {}", articleList.size());
        for (Article article : articleList) {
            log.info("article Title : {}", article);
        }
    }

    @Test
    void countTest() {
        Long count = articleRepository.count(1L, 30001L);
        log.info("article count: {}", count);
    }

    @Test
    void findInfiniteScrollTest() {
        List<Article> articles = articleRepository.findAllInfiniteScroll(1L, 30L);

        log.info("articleSize: {}", articles.size());

        for (Article article : articles) {
            log.info("article Title : {}", article);
        }

        Long articleId = articles.getLast().getArticleId();
        List<Article> lastArticleList = articleRepository.findAllInfiniteScroll(1L, 30L, articleId);

        for (Article article : lastArticleList) {
            log.info("article Title : {}", article);
        }
    }
}