package org.example.crudpractice.domain.post.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.service.CreatePostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/post")
public class PostController {
    private final CreatePostService createPostService;

    @PostMapping("/create")
    public void createPost(@RequestBody PostCreateRequest request) {
        createPostService.createPost(request);
    }
}
