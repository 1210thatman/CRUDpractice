package org.example.crudpractice.domain.board.persistence;

import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}