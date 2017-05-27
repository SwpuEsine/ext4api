package zft.control.manager.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import zft.control.manager.dao.SettleInsInfDao;
import zft.control.manager.entity.SettleInsInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.Map;

/**
 * 通道管理持久层实现类
 * 
 * @author qianpyn
 *
 */
@Repository("settleInsInfDao")
public class SettleInsInfDaoImpl extends GenericBase<SettleInsInf, String>
		implements SettleInsInfDao {

	@Override
	protected Class<?> getClasses() {
		return SettleInsInf.class;
	}

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT  REC_CRT_TS , STLM_ID, DESCR ,USE_FLAG ,UPD_USR_ID ,REC_UPD_TS ");
		sql.append(" FROM TBL_SETTLE_INS_INF t     ");
		sql.append(" WHERE 1 = 1 ");

		SqlUtils.addSql(sql, " t.STLM_ID like :stlmId", params.get("stlmId"));
		SqlUtils.addSql(sql, " DESCR like :descr", params.get("descr"));
		SqlUtils.addSql(sql, " USE_FLAG like :useFlag ", params.get("useFlag"));

		sql.append(" ORDER BY UPD_USR_ID");

		SQLQuery query = this.getCurrentSession()
				.createSQLQuery(sql.toString());
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		query.setMaxResults(limit);
		query.setFirstResult(offset);

		SqlUtils.setParameterLike(query, "stlmId", params.get("stlmId"));
		SqlUtils.setParameterLike(query, "descr", params.get("descr"));
		SqlUtils.setParameterLike(query, "useFlag", params.get("useFlag"));

		GridListRes<Map<String, Object>> res = new GridListRes<>();
		res.setRows(query.list());

		query = this.getCurrentSession().createSQLQuery(
				"SELECT COUNT(1) FROM (" + sql.toString() + ")");
		SqlUtils.setParameterLike(query, "stlmId", params.get("stlmId"));
		SqlUtils.setParameterLike(query, "descr", params.get("descr"));
		SqlUtils.setParameterLike(query, "useFlag", params.get("useFlag"));

		res.setTotal(Integer.parseInt(query.list().get(0).toString()));
		return res;

	}
}
