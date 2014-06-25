package com.art.articlecomment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.articlecomment.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> , ArticleCommentRepositoryCutstom{
	
}
