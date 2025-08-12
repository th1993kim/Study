package kuke.board.comment.controller;

import kuke.board.comment.service.CommentServiceV2;
import kuke.board.comment.service.request.CommentCreateRequestV2;
import kuke.board.comment.service.response.CommentPageResponse;
import kuke.board.comment.service.response.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentControllerV2 {

    private final CommentServiceV2 commentService;

    @GetMapping("/v2/comments/{commentId}")
    public CommentResponse getComment(@PathVariable long commentId) {

        return commentService.read(commentId);
    }

    @PostMapping("/v2/comments")
    public CommentResponse create(@RequestBody CommentCreateRequestV2 request) {
        return commentService.create(request);
    }

    @DeleteMapping("/v2/comments/{commentId}")
    public void delete(@PathVariable long commentId) {
        commentService.delete(commentId);
    }


}
