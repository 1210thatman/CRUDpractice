package org.example.crudpractice.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.post.exception.PostNotFoundException;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.example.crudpractice.domain.post.persistence.dto.response.PostResponse;
import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetPostByIdService {
    private final PostRepository postRepository;

    public PostResponse getPostById(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.map(PostResponse::new).orElseThrow(() -> PostNotFoundException.EXCEPTION);
    }
}