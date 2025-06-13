package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.persistence.dto.request.PostUpdateRequest;
import org.example.crudpractice.domain.post.persistence.dto.response.PostResponse;
import org.example.crudpractice.domain.post.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;
    private final GetAllPostService getAllPostService;
    private final DeletePostService deletePostService;
    private final GetPostByIdService getPostByIdService;

    @PostMapping("{board-id}/post") // http://localhost:8080/post?board-id=1
    public Long createPost(@PathVariable("board-id") Long boardId, @RequestBody PostCreateRequest request) {
        return createPostService.createPost(request, boardId);
    }

    @PatchMapping("posts/{postId}")
    public Long  updatePostById(@RequestParam("post-id")Long postId, @RequestBody PostUpdateRequest request) {
        return updatePostService.updatePostById(postId, request);
    }

    @GetMapping("{boardId}/posts")
    public List<PostResponse> getPostsByBoardId(@PathVariable Long boardId) {
        return getAllPostService.getPostsByBoardId(boardId);
    }

    @GetMapping("posts/{postId}")
    public PostResponse getPostById(@PathVariable("postId") Long postId) {
        return getPostByIdService.getPostById(postId);
    }

    @DeleteMapping("posts")
    public void deletePostsByBoardId(@RequestParam("post-id")Long postId) {
        deletePostService.deletePostService(postId);
    }
}