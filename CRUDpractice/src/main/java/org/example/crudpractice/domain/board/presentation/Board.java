package org.example.crudpractice.domain.board.presentation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.response.BoardResponse;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@NoArgsConstructor
@DynamicUpdate
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int amountOfPost;
    private String adminName;

    @Builder
    public Board(String title, String adminName, int amountOfPost) {
        this.title = title;
        this.adminName = adminName;
        this.amountOfPost = amountOfPost;
    }

    public void update(String title){
        this.title = title;
    }
}