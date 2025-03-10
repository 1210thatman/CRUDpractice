package org.example.crudpractice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardCreateRequest;
import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBoardService {
    final private BoardRepository boardRepository;

    public void createBoard(BoardCreateRequest request) {
        boardRepository.save(
                Board.builder()
                        .title(request.getTitle())
                        .adminName(request.getAdminName())
                        .amountOfPost(0)
                        .build()
        );
    }
}
