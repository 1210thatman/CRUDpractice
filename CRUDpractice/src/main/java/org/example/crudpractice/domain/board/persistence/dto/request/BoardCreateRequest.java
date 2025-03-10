package org.example.crudpractice.domain.board.persistence.dto.request;

import lombok.Getter;

@Getter
public class BoardCreateRequest {
    private String title;
    private String adminName;
}
