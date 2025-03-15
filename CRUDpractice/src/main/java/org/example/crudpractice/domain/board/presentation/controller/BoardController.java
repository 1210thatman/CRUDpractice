package org.example.crudpractice.domain.board.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardCreateRequest;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardUpdateRequest;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final CreateBoardService createBoardService;
    private final GetAllBoardsService getBoardService;
    private final GetBoardByIdService getBoardByIdService;
    private final GetBoardsByAdminNameService getBoardsByAdminNameService;
    private final UpdateBoardService updateBoardService;

    @PostMapping("/create")
    public void createBoard(@RequestBody BoardCreateRequest request) {
        createBoardService.createBoard(request);
    }

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return getBoardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardResponse getBoardById(@PathVariable Long id) throws IllegalAccessException{
        return  getBoardByIdService.getBoardById(id);
    }

    @GetMapping("/admin-name/{adminName}")
    public List<BoardResponse> getBoardsByAdminName(@PathVariable String adminName) throws IllegalAccessException{
        return getBoardsByAdminNameService.getBoardsByAdminName(adminName);
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        updateBoardService.updateBoardById(id, request);
    }
}
