package org.example.crudpractice.domain.post.presentation;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.crudpractice.domain.board.presentation.Board;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int userName;

    @ManyToOne
    private Board board;
}