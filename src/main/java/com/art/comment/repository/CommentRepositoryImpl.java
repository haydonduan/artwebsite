package com.art.comment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.art.comment.dto.CommentDto;
import com.art.production.domain.Production;
import com.util.Constant;

public class CommentRepositoryImpl implements CommentRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_COMMENT_BY_PRODUCTIONID = "SELECT u.id as userId,u.image, c.comment, c.create_time as createTime, u.name FROM "+
			" t_comment c INNER JOIN t_user u ON u.id = c.user_id WHERE c.production_id=:id  AND c.is_review=1 AND c.del_flg=0 ";
	
	private static final String GET_ALL_COMMENT_COUNT = "select count(id) from t_comment WHERE production_id=:id  AND is_review=1 AND del_flg=0";
	
	private static final String GET_ADMIN_COMMENT_NO_REPEAT = "SELECT p.id,p.title FROM t_production p INNER JOIN t_comment c on c.production_id = p.id WHERE c.is_review=0 GROUP BY c.production_id";
	
	private static final String GET_COMMENT_NO_REPLY_BY_PROID = "SELECT c.id, c.`comment`, u.`name`,c.create_time as createTime FROM t_comment c INNER JOIN t_user u ON u.id = c.user_id WHERE "
			+ "production_id = :proId AND is_review = 0 ORDER BY create_time DESC";
	
	private static final String GET_ALL_COMMENT_NO_REPLY_BY_PROID ="select count(id) from t_comment where is_review=0 and production_id=:proId";
	
	private static final String UPDATE_IS_VIEW_FLAG = "update t_comment set is_review=1 where id=:id";
	
	@SuppressWarnings("unchecked")
	public List<CommentDto> getCommentById(Long id) {
		SQLQuery query = em.createNativeQuery(GET_COMMENT_BY_PRODUCTIONID).unwrap(
				SQLQuery.class);
		query.addScalar("userId", LongType.INSTANCE)
		.addScalar("comment", StringType.INSTANCE)
		.addScalar("name", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.setParameter("id", id)
		.setResultTransformer(Transformers.aliasToBean(CommentDto.class));
		return query.list();
	}

	public int getCommentCount(Long id) {
		SQLQuery query = em.createNativeQuery(GET_ALL_COMMENT_COUNT).unwrap(
				SQLQuery.class);
		query.setParameter("id", id);
		return Integer.parseInt(query.uniqueResult()+"");
	}

	@SuppressWarnings("unchecked")
	public List<Production> getAdminNoRepeatComment(int page) {
		SQLQuery query = em.createNativeQuery(GET_ADMIN_COMMENT_NO_REPEAT).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE).addScalar("title", StringType.INSTANCE)
		.setFirstResult(page * Constant.COMMENT_INDEX_PAGE_SIZE).setMaxResults(Constant.COMMENT_INDEX_PAGE_SIZE)
		.setResultTransformer(Transformers.aliasToBean(Production.class));
		return query.list();
	}

	public int getAdminCommentAll() {
		SQLQuery query = em.createNativeQuery(GET_ADMIN_COMMENT_NO_REPEAT).unwrap(
				SQLQuery.class);
		return query.list().size();
	}

	@SuppressWarnings("unchecked")
	public List<CommentDto> getNoReplyCommentByProId(Long ProId,int currentPage) {
		SQLQuery query = em.createNativeQuery(GET_COMMENT_NO_REPLY_BY_PROID).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("comment", StringType.INSTANCE)
		.addScalar("name", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.setParameter("proId", ProId).setFirstResult(currentPage * Constant.COMMENT_NO_REPLY_PAGE_SIZE)
		.setMaxResults(Constant.COMMENT_NO_REPLY_PAGE_SIZE)
		.setResultTransformer(Transformers.aliasToBean(CommentDto.class));
		return query.list();
	}

	public int getAdminNoReplyCommentAllByProId(Long proId) {
		SQLQuery query = em.createNativeQuery(GET_ALL_COMMENT_NO_REPLY_BY_PROID).unwrap(
				SQLQuery.class);
		
		return Integer.parseInt(query.setParameter("proId", proId).uniqueResult()+"");
	}

	public void updateIsReviewFlag(Long commentId) {
		SQLQuery query = em.createNativeQuery(UPDATE_IS_VIEW_FLAG).unwrap(
				SQLQuery.class);
		query.setParameter("id", commentId).executeUpdate();
	}

}
