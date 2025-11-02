package kuke.board.view.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kuke.board.view.repository.entity.ArticleViewCount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ArticleViewCountBackUpRepositoryTest {

    @Autowired
    ArticleViewCountBackUpRepository articleViewCountBackUpRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Test
    @Transactional
    void updateViewCountTest() {
        ArticleViewCount articleViewCount = articleViewCountBackUpRepository.save(ArticleViewCount.init(1L, 0L));

        entityManager.flush();
        entityManager.clear();

        int result1 = articleViewCountBackUpRepository.updateViewCount(articleViewCount.getArticleId(), 100L);
        int result2 = articleViewCountBackUpRepository.updateViewCount(articleViewCount.getArticleId(), 300L);
        int result3 = articleViewCountBackUpRepository.updateViewCount(articleViewCount.getArticleId(), 200L);

        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(1);
        assertThat(result3).isEqualTo(0);

        ArticleViewCount reCount = articleViewCountBackUpRepository.findById(1L).get();
        assertThat(reCount.getViewCount()).isEqualTo(300L);
    }
}