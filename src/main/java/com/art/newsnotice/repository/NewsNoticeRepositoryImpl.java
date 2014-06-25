package com.art.newsnotice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.art.newsnotice.domain.NewsNotice;
import com.util.Constant;

public class NewsNoticeRepositoryImpl implements NewsNoticeRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_DATA_BY_TYPE = "SELECT id,title,create_time as createTime FROM `t_notes_news` WHERE type=:type and del_flg=0 ORDER BY create_time desc";

	private static final String GET_DATA_ALL = "select count(id) from t_notes_news where type=:type and del_flg=0";
	
	private static final String DELETE_NEWS_NOTICE = "update t_notes_news set del_flg=1 where id=:id";
	
	private static final String GET_NEWS_NOTICE = "SELECT id,create_time as createTime,title FROM t_notes_news WHERE type=:newsNoticeType and del_flg=0 order by create_time desc";
	
	private static final String GET_NEWS_PAINTER = "SELECT id,create_time as createTime,title FROM t_notes_news WHERE type=:newsNoticeType and del_flg=0 and is_own=1 order by create_time desc";
	
	@SuppressWarnings("unchecked")
	public List<NewsNotice> getDataList(int type, int currentPage) {
		SQLQuery query = em.createNativeQuery(GET_DATA_BY_TYPE).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE).setParameter("type", type)
		.setFirstResult(currentPage * Constant.BACKSTAGE_NEWS_NOTICE_PAGE_SIZE)
		.setMaxResults(Constant.BACKSTAGE_NEWS_NOTICE_PAGE_SIZE)
		.setResultTransformer(Transformers.aliasToBean(NewsNotice.class));
		return query.list();
	}

	public int getDataAll(int type) {
		SQLQuery query = em.createNativeQuery(GET_DATA_ALL).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.setParameter("type", type).uniqueResult()+"");
	}

	public void deleteByIdType(Long id) {
		SQLQuery query = em.createNativeQuery(DELETE_NEWS_NOTICE).unwrap(
				SQLQuery.class);
		query.setParameter("id", id).executeUpdate();
	}

	
	/**
	 * newsNoticeType 0为新闻   1为公告
	 * 
	 * painterNewsType 1为画家自己的新闻  0为普通 
	 */
	@SuppressWarnings("unchecked")
	public List<NewsNotice> getDataByNewsNotice(int newsNoticeType,
			int currentPage, int painterNewsType) {
		String sql = "";
		int start = 0;
		int size = 0;
		if(newsNoticeType == 0){
			if(painterNewsType == 1){
				sql = GET_NEWS_PAINTER;
				size = Constant.HUAJIAYUSHEHUI_PAGE_NEWS_SIZE;
			}else{
				sql = GET_NEWS_NOTICE;
				size = Constant.INDEX_PAGE_NEWS_SIZE;
			}
		}else{
			sql = GET_NEWS_NOTICE;
			size = Constant.INDEX_PAGE_NOTICE_SIZE;
		}
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.setParameter("newsNoticeType", newsNoticeType)
		.setFirstResult(start)
		.setMaxResults(size);
		query.setResultTransformer(Transformers.aliasToBean(NewsNotice.class));
		return query.list();
	}

	/**
	 * newsNoticeType 0为新闻1为公告
	 */
	@SuppressWarnings("unchecked")
	public List<NewsNotice> getDataByNewsNoticeMore(int newsNoticeType,
			int currentPage) {
		String sql = "SELECT id,title,create_time as createTime from t_notes_news WHERE del_flg=0 and type=:type ORDER BY create_time DESC";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("createTime", TimestampType.INSTANCE)
		.setFirstResult(currentPage * Constant.NEWS_NOTICE_MORE_PAGE_SIZE)
		.setMaxResults(Constant.NEWS_NOTICE_MORE_PAGE_SIZE).setParameter("type",newsNoticeType);
		query.setResultTransformer(Transformers.aliasToBean(NewsNotice.class));
		return query.list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsNotice> getRightData() {
		String sql = "SELECT id,title,image from t_notes_news WHERE del_flg=0 and type=0 and is_own = 1 ORDER BY create_time DESC";
		SQLQuery query = em.createNativeQuery(sql).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.setFirstResult(0)
		.setMaxResults(Constant.NEWS_NOTICE_RIGHT_SIZE);
		query.setResultTransformer(Transformers.aliasToBean(NewsNotice.class));
		return query.list();
	}
}
