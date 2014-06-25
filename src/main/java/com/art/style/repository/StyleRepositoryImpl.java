package com.art.style.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;

public class StyleRepositoryImpl implements StyleRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void updateImage(Long id, String image) {
		String sql = "update t_style set image=:image where id=:id";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.setParameter("image", image).setParameter("id", id);
		query.executeUpdate();
	}
	

}
