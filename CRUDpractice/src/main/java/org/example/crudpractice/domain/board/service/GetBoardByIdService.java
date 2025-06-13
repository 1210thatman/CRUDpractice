package org.example.crudpractice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.exception.BoardNotFoundException;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetBoardByIdService {
    private final BoardRepository boardRepository;

    public BoardResponse getBoardById(Long id) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        return boardOptional.map(BoardResponse::new).orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }
}