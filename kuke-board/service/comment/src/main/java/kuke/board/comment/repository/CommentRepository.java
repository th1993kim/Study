    package kuke.board.comment.repository;

import kuke.board.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            value = """
                SELECT COUNT(*) 
                  FROM (
                          SELECT comment_id 
                            FROM comment cm
                           WHERE article_id = :articleId 
                             AND parent_comment_id = :parentCommentId          
                           LIMIT :limit           
                        ) AS comment           
            """,
            nativeQuery = true
    )
    long countBy(
            @Param("articleId") long articleId,
            @Param("parentCommentId") long parentCommentId,
            @Param("limit") Long limit
    );

    @Query(
            value = """
                        SELECT comment.comment_id,
                               comment.content,
                               comment.parent_comment_id,
                               comment.article_id,
                               comment.writer_id,
                               comment.deleted,
                               comment.created_at
                          FROM (
                                 SELECT comment_id 
                                   FROM comment
                                  WHERE article_id = :articleId
                               ORDER BY parent_comment_id ASC, comment_id asc
                                  LIMIT :limit OFFSET :offset
                               ) t 
                     LEFT JOIN comment 
                            ON t.comment_id = comment.comment_id 
                    """,
            nativeQuery = true
    )
    List<Comment> findAll(
            @Param("articleId") Long articleId,
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

    @Query(
            value = """
                        SELECT COUNT(*)
                          FROM (SELECT comment_id
                                  FROM comment
                                 WHERE article_id = :articleId 
                                 LIMIT :limit) t
                    """,
            nativeQuery = true
    )
    Long count(
            @Param("articleId") Long articleId,
            @Param("limit") Long limit
    );


    @Query(
            value = """
                        SELECT comment.comment_id,
                               comment.content,
                               comment.parent_comment_id,
                               comment.article_id,
                               comment.writer_id,
                               comment.deleted,
                               comment.created_at
                          FROM comment
                         WHERE comment.article_id = :articleId
                      ORDER BY comment.parent_comment_id ASC, comment.comment_id asc
                         LIMIT :limit
                    """,
            nativeQuery = true
    )
    List<Comment> findAllInfInfiniteScroll(
            @Param("articleId") Long articleId,
            @Param("limit") Long limit
    );

    @Query(
            value = """
                        SELECT comment.comment_id,
                               comment.content,
                               comment.parent_comment_id,
                               comment.article_id,
                               comment.writer_id,
                               comment.deleted,
                               comment.created_at
                          FROM comment
                         WHERE comment.article_id = :articleId
                           AND (comment.parent_comment_id > :parentCommentId
                                OR
                                (comment.parent_comment_id = :parentCommentId AND comment.comment_id > :commentId)) 
                      ORDER BY comment.parent_comment_id ASC, comment.comment_id asc
                         LIMIT :limit
                    """,
            nativeQuery = true
    )
    List<Comment> findAllInfInfiniteScroll(
            @Param("articleId") Long articleId,
            @Param("parentCommentId") Long parentCommentId,
            @Param("commentId") Long commentId,
            @Param("limit") Long limit
    );

}
