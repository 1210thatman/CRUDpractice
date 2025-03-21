package org.example.crudpractice.domain.post.presentation;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.crudpractice.domain.board.presentation.Board;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Builder
    public Post(String title, String content, String userName, Board board) {
        this.title = title;
        this.content = content;
        this.userName = userName;
        this.board = board;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}