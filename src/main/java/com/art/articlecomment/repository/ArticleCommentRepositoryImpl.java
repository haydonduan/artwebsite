package com.art.articlecomment.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.art.articlecomment.dto.ArticleCommentDto;
import com.util.Constant;

public class ArticleCommentRepositoryImpl implements ArticleCommentRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_COMMENT = "SELECT a.comment,a.create_time as createTime,u.name,u.image,u.image FROM t_article_comment a "+
					"INNER JOIN t_user u on u.id = a.user_id "+
					"WHERE a.article_id=:id AND a.del_flg = 0 and is_reply=1";
	
	private static final String GET_NO_REPLY_COMMENT= "select c.id,u.name,c.comment,c.create_time as createTime from t_article_comment c "+ 
					"left join t_user u on u.id = c.user_id "+
					"where c.article_id=:articleId and c.is_reply=0";
	
	@SuppressWarnings("unchecked")
	public List<ArticleCommentDto> getArtcleComments(Long id) {
		SQLQuery query = em.createNativeQuery(GET_COMMENT).unwrap(
				SQLQuery.class);
		query.addScalar("comment", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("name", StringType.INSTANCE).addScalar("image", StringType.INSTANCE).setParameter("id", id)
		.setResultTransformer(Transformers.aliasToBean(ArticleCommentDto.class));
		return query.list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleCommentDto> getCommentByNoReply(Long id,int page) {
		SQLQuery query = em.createNativeQuery(GET_NO_REPLY_COMMENT).unwrap(
				SQLQuery.class);
		query.addScalar("comment", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("id", LongType.INSTANCE)
		.addScalar("name", StringType.INSTANCE).setParameter("articleId", id)
		.setFirstResult(page * Constant.BACKSTAGE_FORUM_PAGE_SIZE)
		.setMaxResults(Constant.BACKSTAGE_FORUM_PAGE_SIZE)
		.setResultTransformer(Transformers.aliasToBean(ArticleCommentDto.class));
		return query.list();
	}


	@Override
	public int getCommentCountByNoReply(Long id) {
		String sql = "select count(id) from t_article_comment where is_reply = 0 and article_id=:id";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
	}


	@Override
	public void updateIsReply(Long id) {
		String sql = "update t_article_comment set is_reply=1 where id=:id";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	
	
}
