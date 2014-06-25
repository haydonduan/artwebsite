package com.art.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.article.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> , ArticleRepositoryCutstom{
	public List<Article> findByUserId(Long id);
}
