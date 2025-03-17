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
    private final DeleteBoardById deleteBoardById;

    @PostMapping("/create")
    public void createBoard(@RequestBody BoardCreateRequest request) {
        createBoardService.createBoard(request);
    }

    @GetMapping
    public List<BoardResponse> getAllBoards() {
        return getBoardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardResponse getBoardById(@PathVariable Long id){
        return  getBoardByIdService.getBoardById(id);
    }

    @GetMapping("/admin-name")
    public List<BoardResponse> getBoardsByAdminName(@RequestParam("admin-name") String adminName) {
        return getBoardsByAdminNameService.getBoardsByAdminName(adminName);
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable Long id, @RequestBody BoardUpdateRequest request) {
        updateBoardService.updateBoardById(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable Long id){
        deleteBoardById.deleteBoardById(id);
    }
}
