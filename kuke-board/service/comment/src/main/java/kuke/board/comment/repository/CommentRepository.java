package kuke.board.comment.repository;

import kuke.board.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            value = """
                SELECT COUNT(*) 
                  FROM (
                          SELECT comment_id 
                            FROM comment
                           WHERE board_id = :board_id 
                             AND parent_comment_id = :parent_comment_id          
                           LIMIT :limit           
                        )           
            """,
            nativeQuery = true
    )
    long countBy(
            @Param("articleId") long articleId,
            @Param("parentCommentId") long parentCommentId,
            @Param("limit") Long limit
    );
}
