package org.example.crudpractice.domain.post.persistence.dto.response;

import lombok.Getter;
import org.example.crudpractice.domain.board.presentation.Board;
import org.example.crudpractice.domain.post.presentation.Post;

@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}