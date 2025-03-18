package org.example.crudpractice.domain.post.persistence.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequest {
    private String title;
    private String content;
    private String userName;
}