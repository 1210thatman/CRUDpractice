package org.example.crudpractice.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.post.exception.PostNotFoundException;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.example.crudpractice.domain.post.persistence.dto.request.PostUpdateRequest;
import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService {
    private final PostRepository postRepository;

    @Transactional
    public Long updatePostById(Long id,PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findById(id).orElseThrow(() -> PostNotFoundException.EXCEPTION);

        post.update(postUpdateRequest.getTitle(), postUpdateRequest.getContent());
        return post.getId();
    }
}