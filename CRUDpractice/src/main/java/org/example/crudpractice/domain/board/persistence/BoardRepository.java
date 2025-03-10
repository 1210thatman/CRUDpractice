package org.example.crudpractice.domain.board.persistence;

import org.example.crudpractice.domain.board.presentation.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}