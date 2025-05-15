package org.example.todo.Reply.Repository;

import org.example.todo.Reply.Entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
}
