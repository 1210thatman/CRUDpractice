package org.example.crudpractice.domain.board.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.request.BoardCreateRequest;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.example.crudpractice.domain.board.service.CreateBoardService;
import org.example.crudpractice.domain.board.service.GetAllBoardsService;
import org.example.crudpractice.domain.board.service.GetBoardByIdService;
import org.example.crudpractice.domain.board.service.GetBoardsByAdminNameService;
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
}
