package org.example.crudpractice.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePostService {
    private final PostRepository postRepository;
    public void deletePostService(Long id) {
        postRepository.deleteById(id);
    }
}
