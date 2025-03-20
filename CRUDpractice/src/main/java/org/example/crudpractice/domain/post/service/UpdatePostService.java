package org.example.crudpractice.domain.post.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.post.persistence.dto.PostRepository;
import org.example.crudpractice.domain.post.persistence.dto.request.PostUpdateRequest;
import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void updatePostById(Long boardId, PostUpdateRequest postUpdateRequest) {
        //Board board = boardRepository.findById(boardId);
    }
}
