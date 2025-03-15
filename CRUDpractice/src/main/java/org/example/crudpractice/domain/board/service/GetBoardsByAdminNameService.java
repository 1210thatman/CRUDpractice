package org.example.crudpractice.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.BoardRepository;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBoardsByAdminNameService {
    final private BoardRepository boardRepository;

    public List<BoardResponse> getBoardsByAdminName(String adminName) {
        List<Board> boards = boardRepository.findByAdminName(adminName);
        if (boards.isEmpty()) {
            throw new RuntimeException("Admin name not found: " + adminName);
        }
        return boards.stream().map(BoardResponse::new).toList();
    }
}
