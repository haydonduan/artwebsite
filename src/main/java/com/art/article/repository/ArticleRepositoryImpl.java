package com.art.article.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.ByteType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.art.article.domain.Article;
import com.art.article.dto.ArticleDto;

public class ArticleRepositoryImpl implements ArticleRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	
	private static final String GET_NEW = "SELECT id,title,create_time as createTime from t_article where is_view=1 ORDER BY create_time desc";
	
	private static final String GET_HOT = "SELECT id,title,create_time as createTime from t_article where is_view=1 ORDER BY click_number desc";
	
	private static final String GET_NEW_COMMENT = "SELECT a.id,a.title,a.create_time as createTime FROM t_article a LEFT JOIN t_article_comment c ON c.article_id = a.id  where a.is_view=1 group by a.id ORDER BY c.create_time DESC";
	
	private static final String GET_ARTICLE_DETAIL = "SELECT a.id,u.name,u.image,a.title,a.is_view as isView,a.content,if (a.click_number is null,0,a.click_number) as clickNum,if (arc.artComment is null,0,arc.artComment) "
			+ "as artComment,if(am.artCount is null,0,am.artCount) as artCount from t_article a "+
			"INNER JOIN t_user u ON u.id = a.user_id "+
			"LEFT JOIN (SELECT count(id) as artComment,article_id FROM t_article_comment GROUP BY article_id) arc ON arc.article_id=a.id "+
			"LEFT JOIN (SELECT count(id) as artCount,user_id FROM t_article GROUP BY user_id) am ON am.user_id = a.user_id "+
			"WHERE a.id =:id";
	
	private static final String GET_CLICK_NUMNER = "select click_number from t_article where id=:id";
	
	private static final String UPDATE_CLICK_NUMNER = "update t_article set click_number=:num where id=:id";
	
	private static final String GET_FORUM_COUNT_ = "select count(id) from t_article where user_id=:userId and is_view = 0";
	
	private static final String UPDATE_IS_VIEW = "update t_article set is_view=:view where id=:id";
	
	private static final String GET_NO_REPLY_COMMENTS= "select a.id,a.title from t_article_comment c " +  
			"left join t_article a on a.id = c.article_id " +
			"where c.is_reply = 0 group by a.id;";
	
	@SuppressWarnings("unchecked")
	public List<Article> getNewArticle() {
		SQLQuery query = em.createNativeQuery(GET_NEW).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE).addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("title", StringType.INSTANCE).setFirstResult(0).setMaxResults(5)
		.setResultTransformer(Transformers.aliasToBean(Article.class));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getNewCommentArticle() {
		SQLQuery query = em.createNativeQuery(GET_NEW_COMMENT).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE).addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("title", StringType.INSTANCE).setFirstResult(0).setMaxResults(4)
		.setResultTransformer(Transformers.aliasToBean(Article.class));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getHotArticle() {
		SQLQuery query = em.createNativeQuery(GET_HOT).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE).addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("title", StringType.INSTANCE).setFirstResult(0).setMaxResults(5)
		.setResultTransformer(Transformers.aliasToBean(Article.class));
		return query.list();
	}

	public ArticleDto getArtcleDetail(Long id) {
		SQLQuery query = em.createNativeQuery(GET_ARTICLE_DETAIL).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("name", StringType.INSTANCE)
		.addScalar("content", StringType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("clickNum", IntegerType.INSTANCE)
		.addScalar("isView", ByteType.INSTANCE)
		.addScalar("artComment", IntegerType.INSTANCE)
		.addScalar("artCount", IntegerType.INSTANCE)
		.setParameter("id", id)
		.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));
		return (ArticleDto)query.uniqueResult();
	}

	public void addClickNum(Long id) {
		SQLQuery query = em.createNativeQuery(GET_CLICK_NUMNER).unwrap(
				SQLQuery.class);
		int loveNum = Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
		SQLQuery query2 = em.createNativeQuery(UPDATE_CLICK_NUMNER).unwrap(
				SQLQuery.class);
		query2.setParameter("id", id).setParameter("num", loveNum+1).executeUpdate();
	}
	
	public int getForumCountByUserId(Long userId) {
		SQLQuery query = em.createNativeQuery(GET_FORUM_COUNT_).unwrap(
				SQLQuery.class);
		query.setParameter("userId", userId);
		return Integer.parseInt(query.uniqueResult()+"");
	}

	@SuppressWarnings("unchecked")
	public List<ArticleDto> getArticleByPage(int currentPage,int size,int type) {
		String sql = "";
		if(type == 1){
			sql = "SELECT a.id, a.title, a.create_time AS createTime, u.`name` FROM t_article a INNER JOIN t_user u ON u.id = a.user_id where a.is_view=1 ORDER BY create_time DESC";
		}else{
			sql = "SELECT a.id, a.title, a.create_time AS createTime, u.`name` FROM t_article a INNER JOIN t_user u ON u.id = a.user_id where a.is_view=0 ORDER BY create_time DESC";
		}
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.addScalar("name", StringType.INSTANCE)
		.setFirstResult(currentPage * size)
		.setMaxResults(size)
		.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));
		return query.list();
	}

	public int getPage(int page,int type) {
		String sql = "";
		if(type == 1){
			sql = "select count(id) from t_article where is_view = 1";
		}else if(type == 2){
			sql = "select count(id) from t_article where is_view = 0";
		}else if(type == 3){
			sql = "select count(id) from t_article_comment where is_reply = 0";
		}
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.uniqueResult()+"");
	}

	@Override
	public void updateIsViewById(Long id,int type) {
		SQLQuery query = em.createNativeQuery(UPDATE_IS_VIEW).unwrap(
				SQLQuery.class);
		if(type == 1){
			query.setParameter("view", 1);
		}else{
			query.setParameter("view", 2);
		}
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleDto> getNoReplyArticle(int page) {
		SQLQuery query = em.createNativeQuery(GET_NO_REPLY_COMMENTS).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));
		return query.list();
	}

	@Override
	public int getCommentCount(Long id) {
		String sql = "select count(id) from t_article_comment where is_reply=0 and article_id=:id";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
	}
}
