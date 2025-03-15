package org.example.crudpractice.domain.board.persistence.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.crudpractice.domain.board.presentation.Board;

@Getter
@Builder
public class BoardResponse {
    private Long id;
    private String title;
    private int amountOfPost;
    private String adminName;

    public static BoardResponse boardResponse(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .amountOfPost(board.getAmountOfPost())
                .adminName(board.getAdminName())
                .build();
    }
}
