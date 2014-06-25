package com.art.newsnotice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.newsnotice.domain.NewsNotice;

public interface NewsNoticeRepository extends JpaRepository<NewsNotice, Long> , NewsNoticeRepositoryCutstom{
}
