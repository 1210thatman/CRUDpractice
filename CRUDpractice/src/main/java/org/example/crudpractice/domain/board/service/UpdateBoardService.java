package org.example.crudpractice.domain.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardUpdateRequest;
import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void updateBoardById(Long id,  BoardUpdateRequest boardUpdateRequest){
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        board.update(boardUpdateRequest.getTitle());
        boardRepository.save(board);
    }
}
