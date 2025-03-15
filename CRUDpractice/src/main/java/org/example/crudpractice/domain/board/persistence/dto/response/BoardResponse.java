package org.example.crudpractice.domain.board.persistence.dto.response;

import lombok.Getter;

@Getter
public class BoardResponse {
    private Long id;
    private String title;
    private int amountOfPost;
    private String adminName;
}
