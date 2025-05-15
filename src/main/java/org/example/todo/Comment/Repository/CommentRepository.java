package org.example.todo.Comment.Repository;

import org.example.todo.Comment.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
