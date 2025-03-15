package org.example.crudpractice.domain.board.persistence.dto.response;

import lombok.Getter;
import org.example.crudpractice.domain.board.presentation.Board;

@Getter
public class BoardResponse {
    private Long id;
    private String title;
    private int amountOfPost;
    private String adminName;

    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.amountOfPost = board.getAmountOfPost();
        this.adminName = board.getAdminName();
    }
}
