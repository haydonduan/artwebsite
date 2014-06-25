package com.art.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.art.score.domain.Score;
import com.art.user.domain.User;

public interface ScoreRepository extends JpaRepository<Score, Long> , ScoreRepositoryCutstom{
	public Score findByUserId(User user);
}
