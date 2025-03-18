package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.service.CreatePostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final CreatePostService createPostService;

    @PostMapping("/create") //create?board-id=1
    public void createPost(@RequestParam("board-id") Long boardId, @RequestBody PostCreateRequest request) {
        createPostService.createPost(request, boardId);
    }
}