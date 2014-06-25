package com.art.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.ByteType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.art.user.domain.User;
import com.art.user.dto.UserDto;

public class UserRepositoryImpl implements UserRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_USER_BY_ISPAINTER = "select id,name,detail,image,telephone,email,address from t_user where is_painter=:isPainter";
	
	private static final String GET_USER_BY_NAME = "select id,name,password,image from t_user where name=:name";
	
	private static final String GET_USER_BY_ADMIN_NAME = "select id,name,password,image,is_admin as isAdmin from t_user where name=:name and is_admin=1";
	
	private static final String UPDATE_ADMIN_USER = "update t_user set name=:name,password=:password where id=:id";
	
	public User getPainter() {
		SQLQuery query = em.createNativeQuery(GET_USER_BY_ISPAINTER).unwrap(
				SQLQuery.class);
		query.addScalar("name", StringType.INSTANCE)
		.addScalar("id", LongType.INSTANCE)
		.addScalar("detail", StringType.INSTANCE)
		.addScalar("address", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("telephone", StringType.INSTANCE)
		.addScalar("email", StringType.INSTANCE)
		.setParameter("isPainter", 1).setResultTransformer(Transformers.aliasToBean(User.class));
		return (User)query.uniqueResult();
	}

	public UserDto getUserByName(String name) {
		SQLQuery query = em.createNativeQuery(GET_USER_BY_NAME).unwrap(
				SQLQuery.class);
		query.setParameter("name", name);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("password", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("name", StringType.INSTANCE);
		query.setResultTransformer(Transformers.aliasToBean(UserDto.class));
		return (UserDto)query.uniqueResult();
	}

	public UserDto getUserByAdminName(String name) {
		SQLQuery query = em.createNativeQuery(GET_USER_BY_ADMIN_NAME).unwrap(
				SQLQuery.class);
		query.setParameter("name", name);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("password", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("isAdmin", ByteType.INSTANCE)
		.addScalar("name", StringType.INSTANCE);
		query.setResultTransformer(Transformers.aliasToBean(UserDto.class));
		return (UserDto)query.uniqueResult();
	}

	public void updateAdminUser(Long id, String name, String password) {
		SQLQuery query = em.createNativeQuery(UPDATE_ADMIN_USER).unwrap(
				SQLQuery.class);
		query.setParameter("id", id)
		.setParameter("name", name)
		.setParameter("password", password)
		.executeUpdate();
	}

}
