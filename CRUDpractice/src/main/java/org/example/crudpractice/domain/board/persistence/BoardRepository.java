package org.example.crudpractice.domain.board.persistence;

import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByAdminName(String adminName);
}