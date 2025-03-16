package org.example.crudpractice.domain.post.persistence.dto.request;

import lombok.Getter;

@Getter
public class PostCreateRequest {
    private String title;
    private String content;
    private String userName;
    private Long boardId;
}