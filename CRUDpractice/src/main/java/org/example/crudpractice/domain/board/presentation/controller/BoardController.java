package org.example.crudpractice.domain.board.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardCreateRequest;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.board.service.CreateBoardService;
import org.example.crudpractice.domain.board.service.GetBoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final CreateBoardService createBoardService;
    private final GetBoardService getBoardService;

    @PostMapping("/create")
    public void createBoard(@RequestBody BoardCreateRequest request) {
        createBoardService.createBoard(request);
    }

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return getBoardService.getAllBoards();
    }
}
