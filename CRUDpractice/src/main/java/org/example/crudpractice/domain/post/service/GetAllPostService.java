package org.example.crudpractice.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.example.crudpractice.domain.post.persistence.dto.response.PostResponse;
import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllPostService {
    final private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByBoardId(Long boardId) {
        List<Post> posts = postRepository.findAllByBoardId(boardId);
        return posts.stream().map(PostResponse::new).toList();
    }
}