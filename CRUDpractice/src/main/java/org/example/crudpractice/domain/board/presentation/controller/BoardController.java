package org.example.crudpractice.domain.board.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardCreateRequest;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.board.service.CreateBoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final CreateBoardService createBoardService;

    @PostMapping("/create")
    public void createBoard(@RequestBody BoardCreateRequest request) {
        createBoardService.createBoard(request);
    }
}
