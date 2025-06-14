package org.example.crudpractice.domain.post.persistence.dto;

import org.example.crudpractice.domain.post.presentation.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByBoardId(Long boardId);
}