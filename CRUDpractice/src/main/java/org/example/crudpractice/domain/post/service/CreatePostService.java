package org.example.crudpractice.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.example.crudpractice.domain.post.persistence.dto.request.PostCreateRequest;
import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePostService {
    final private PostRepository postRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Long createPost(PostCreateRequest request, Long  boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .userName(request.getUserName())
                .board(board)
                .build();

        board.increasePostCount(); //더티체킹
//spring di, ioc 작동원리, 김영한 jpa 책, 강의,
        return postRepository.save(post).getId();
    }
}