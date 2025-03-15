package org.example.crudpractice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetBoardService {
    final private BoardRepository boardRepository;

    public List<BoardResponse> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream().map(BoardResponse::new).toList();
    }
}