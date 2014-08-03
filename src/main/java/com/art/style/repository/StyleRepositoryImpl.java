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

	@Override
	/*
	 * (non-Javadoc)
	 * type :
	 * 		0 title
	 * 		1 color
	 * 		2 footer
	 * @see com.art.style.repository.StyleRepositoryCutstom#updateFlashFontColor(java.lang.String, int)
	 */
	public void updateFlashFontColor(String color, int type) {
		String sql = "";
		if(type == 0){
			sql = "update t_style set image=:color where type=101";
		}else if(type == 1){
			color = "#" + color;
			sql = "update t_style set image=:color where type=100";
		}else{
			sql = "update t_style set image=:color where type=102";
		}
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.setParameter("color", color);
		query.executeUpdate();
	}
	

}
