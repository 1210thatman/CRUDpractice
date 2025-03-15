package org.example.crudpractice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBoardById {
    private final BoardRepository boardRepository;
    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
}
