package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.board.service.UpdateBoardService;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.persistence.dto.request.PostUpdateRequest;
import org.example.crudpractice.domain.post.persistence.dto.response.PostResponse;
import org.example.crudpractice.domain.post.service.CreatePostService;
import org.example.crudpractice.domain.post.service.DeletePostService;
import org.example.crudpractice.domain.post.service.GetPostService;
import org.example.crudpractice.domain.post.service.UpdatePostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;
    private final GetPostService getPostService;
    private final DeletePostService deletePostService;

    @PostMapping("/{boardId}/post") //create?board-id=1
    public Long createPost(@RequestParam("board-id") Long boardId, @RequestBody PostCreateRequest request) {
        return createPostService.createPost(request, boardId);
    }

    @PatchMapping("posts/{postId}")
    public Long  updatePostById(@RequestParam("post-id")Long postId, @RequestBody PostUpdateRequest request) {
        return updatePostService.updatePostById(postId, request);
    }

    @GetMapping("{boardId}/posts")
    public List<PostResponse> getPostsByBoardId(@PathVariable Long boardId) {
        return getPostService.getPostsByBoardId(boardId);
    }

    @DeleteMapping("posts")
    public void deletePostsByBoardId(@RequestParam("board-id")Long boardId) {
        deletePostService.deletePostService(boardId);
    }
}