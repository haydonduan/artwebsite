package com.art.score.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;

public class ScoreRepositoryImpl implements ScoreRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String UPDATE_SCORE = "update t_score set score=:score where user_id=:userId";

	@Override
	public void updateScore(Long userId,int score) {
		SQLQuery query = em.createNativeQuery(UPDATE_SCORE).unwrap(
				SQLQuery.class);
		query.setParameter("score", score).setParameter("userId", userId);
		query.executeUpdate();
	}

}
