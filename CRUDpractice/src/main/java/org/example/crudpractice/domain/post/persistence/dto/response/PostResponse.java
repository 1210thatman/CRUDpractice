package org.example.crudpractice.domain.post.persistence.dto.response;

import lombok.Getter;
import org.example.crudpractice.domain.board.presentation.Board;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private Board boardId;
}