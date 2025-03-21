package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.board.service.UpdateBoardService;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.persistence.dto.request.PostUpdateRequest;
import org.example.crudpractice.domain.post.service.CreatePostService;
import org.example.crudpractice.domain.post.service.UpdatePostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final CreatePostService createPostService;
    private final UpdatePostService updatePostService;

    @PostMapping("/create") //create?board-id=1
    public Long createPost(@RequestParam("board-id") Long boardId, @RequestBody PostCreateRequest request) {
        return createPostService.createPost(request, boardId);
    }

    @PutMapping("/{id}")
    public Long  updatePostById(@PathVariable Long id, @RequestParam("board-id") Long boardId, @RequestBody PostUpdateRequest request) {
        return updatePostService.updatePostById(id, boardId, request);
    }
}