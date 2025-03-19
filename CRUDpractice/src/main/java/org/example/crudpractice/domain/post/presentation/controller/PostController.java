package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.service.CreatePostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final CreatePostService createPostService;

    @PostMapping("/create") //create?board-id=1
    public ResponseEntity<Long> createPost(@RequestParam("board-id") Long boardId, @RequestBody PostCreateRequest request) {
        Long postId = createPostService.createPost(request, boardId);
        return ResponseEntity.status(HttpStatus.CREATED).body(postId);
    }
}