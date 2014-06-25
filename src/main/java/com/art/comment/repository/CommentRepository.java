package com.art.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> , CommentRepositoryCutstom{
	
}
