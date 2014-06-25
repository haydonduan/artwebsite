package com.art.menu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.art.menu.domain.Menu;
import com.art.production.domain.Production;
import com.util.Constant;

public class MenuRepositoryImpl implements MenuRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_MENU = "select id,text,parent_id as parnetId from t_menu where del_flg=0 order by sequence asc";
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenu() {
		SQLQuery query = em.createNativeQuery(GET_MENU).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("text", StringType.INSTANCE)
		.addScalar("parnetId", LongType.INSTANCE)
		.setResultTransformer(Transformers.aliasToBean(Menu.class));
		return query.list();
	}

}
