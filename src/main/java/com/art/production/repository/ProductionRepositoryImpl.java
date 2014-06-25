package com.art.production.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import com.art.production.domain.Production;
import com.util.Constant;

public class ProductionRepositoryImpl implements ProductionRepositoryCutstom {

	@PersistenceContext
	private EntityManager em;
	
	private static final String GET_JS_GALLERY = "select id,title,image from t_production where del_flg=0 order by finish_time desc";
	
	private static final String GET_PRODUCTION_BY_TYPE_PAGE = "select p.id,p.image,p.title,p.finish_time as finishTime,p.love_num as loveNum,"
					+"p.scan_num as scanNum ,if (c.commentCount is null,0,c.commentCount) as commentCount "+
					"from t_production p left join ( "+
					"select count(id) as commentCount,production_id from t_comment where is_review=1 GROUP BY production_id "+
					") c on c.production_id = p.id where p.del_flg=0 and p.type=:type order by p.finish_time desc";
	
	private static final String GET_PRODUCTION_ALL_COUNT = "select count(id) from t_production where del_flg=0 and type=:type";
	
	private static final String GET_PRODUCTION_BY_ID = "select id,title,finish_time as finishTime,inspiration,image,love_num as loveNum,type as productionType from t_production where id=:id and del_flg=0";
	
	private static final String GET_SCANNUM_BY_ID = "select scan_num from t_production where id=:id";
	
	private static final String UPDATE_SCANNUM_BY_ID = "update t_production set scan_num=:scanNum where id=:id";
	
	private static final String GET_LOVENUM_BY_ID = "select love_num from t_production where id=:id";
	
	private static final String UPDATE_LOVENUM_BY_ID = "update t_production set love_num=:scanNum where id=:id";
	
	private static final String GET_PRODUCTION_BY_PAGE = "SELECT id,title,finish_time as finishTime,type as productionType,scan_num as scanNum,love_num as loveNum FROM t_production where del_flg = 0 ORDER BY finish_time desc";
	
	private static final String GET_PRODUCTION_ADMIN_ALL_COUNT = "select count(id) from t_production where del_flg = 0";
	
	private static final String UPDATE_DEL_FLG_BY_ID = "update t_production set del_flg = 1 where id=:id";
	
	@SuppressWarnings("unchecked")
	public List<Production> getJSGallery() {
		SQLQuery query = em.createNativeQuery(GET_JS_GALLERY).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.setFirstResult(0).setMaxResults(Constant.JS_GALLERY)
		.setResultTransformer(Transformers.aliasToBean(Production.class));
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Production> getProByTypeAndPage(int type, int page,int pageSize) {
		SQLQuery query = em.createNativeQuery(GET_PRODUCTION_BY_TYPE_PAGE).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("loveNum", IntegerType.INSTANCE)
		.addScalar("scanNum", IntegerType.INSTANCE)
		.addScalar("commentCount", IntegerType.INSTANCE)
		.addScalar("finishTime", TimestampType.INSTANCE)
		.setParameter("type", type)
		.setFirstResult(page * pageSize).setMaxResults(pageSize)
		.setResultTransformer(Transformers.aliasToBean(Production.class));
		return query.list();
	}

	public int getProductionAll(int type) {
		SQLQuery query = em.createNativeQuery(GET_PRODUCTION_ALL_COUNT).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.setParameter("type", type).uniqueResult()+"");
	}

	public Production getProductionById(Long id) {
		SQLQuery query = em.createNativeQuery(GET_PRODUCTION_BY_ID).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("image", StringType.INSTANCE)
		.addScalar("inspiration", StringType.INSTANCE)
		.addScalar("productionType", IntegerType.INSTANCE)
		.addScalar("loveNum", IntegerType.INSTANCE)
		.addScalar("finishTime", TimestampType.INSTANCE)
		.setParameter("id", id)
		.setResultTransformer(Transformers.aliasToBean(Production.class));
		return (Production)query.uniqueResult();
	}

	public void addScanNum(Long id) {
		SQLQuery query = em.createNativeQuery(GET_SCANNUM_BY_ID).unwrap(
				SQLQuery.class);
		int scanNum = Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
		SQLQuery query2 = em.createNativeQuery(UPDATE_SCANNUM_BY_ID).unwrap(
				SQLQuery.class);
		query2.setParameter("id", id).setParameter("scanNum", scanNum+1).executeUpdate();
	}

	public void addLoveNum(Long id) {
		SQLQuery query = em.createNativeQuery(GET_LOVENUM_BY_ID).unwrap(
				SQLQuery.class);
		int loveNum = Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
		SQLQuery query2 = em.createNativeQuery(UPDATE_LOVENUM_BY_ID).unwrap(
				SQLQuery.class);
		query2.setParameter("id", id).setParameter("scanNum", loveNum+1).executeUpdate();
	}

	public int getLoveNum(Long id) {
		SQLQuery query = em.createNativeQuery(GET_LOVENUM_BY_ID).unwrap(
				SQLQuery.class);
		int scanNum = Integer.parseInt(query.setParameter("id", id).uniqueResult()+"");
		return scanNum;
	}

	@SuppressWarnings("unchecked")
	public List<Production> getProByAdminPage(int page, int pageSize) {
		SQLQuery query = em.createNativeQuery(GET_PRODUCTION_BY_PAGE).unwrap(
				SQLQuery.class);
		query.addScalar("id", LongType.INSTANCE)
		.addScalar("title", StringType.INSTANCE)
		.addScalar("loveNum", IntegerType.INSTANCE)
		.addScalar("scanNum", IntegerType.INSTANCE)
		.addScalar("productionType", IntegerType.INSTANCE)
		.addScalar("finishTime", TimestampType.INSTANCE)
		.setFirstResult(page * pageSize).setMaxResults(pageSize)
		.setResultTransformer(Transformers.aliasToBean(Production.class));
		return query.list();
	}

	public int getAdminProductionAll() {
		SQLQuery query = em.createNativeQuery(GET_PRODUCTION_ADMIN_ALL_COUNT).unwrap(
				SQLQuery.class);
		return Integer.parseInt(query.uniqueResult()+"");
	}

	public void updateDelFlg(Long id) {
		SQLQuery query = em.createNativeQuery(UPDATE_DEL_FLG_BY_ID).unwrap(
				SQLQuery.class);
		query.setParameter("id", id).executeUpdate();
	}

}
