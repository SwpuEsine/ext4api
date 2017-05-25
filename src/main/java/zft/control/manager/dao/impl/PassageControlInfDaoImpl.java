package zft.control.manager.dao.impl;

import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import zft.control.manager.dao.PassageControlInfDao;
import zft.control.manager.dao.PassageCostInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.PassageControlInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;
@Repository("passageControlInfDao")
public class PassageControlInfDaoImpl extends GenericBase<PassageCostInfo, Integer> implements PassageControlInfDao {

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT a.ID, a.ROUTE_CTL_ID, a.ROUTE_NAME, a.ROUTE_CTL_STA, a.CARD_TP_USE_FLAG, a.CARD_TP, ");
        sql.append(" a.ISSUER_USE_FLAG, a.ISSUER_CD, a.BIN_LEN, a.BIN_NO, a.TXN_NUM_USE_FLAG, a.TXN_NUM, a.TXN_AMT_USE_FLAG, a.MIN_TXN_AMT, ");
        sql.append(" a.MAX_TXN_AMT, a.MCHT_TYPE_USE_FLAG, a.MCHT_TYPE,a.TERM_TYPE_USE_FLAG,a.TERM_TYPE,");
        sql.append(" a.MCHT_GROUP_USE_FLAG, a.MCHT_GROUP_ID, a.MCHT_FEE_TYPE_USE_FLAG,a.MCHT_FEE_TYPE,a.MCHT_TP_GRP_USE_FLAG,");
        sql.append(" a.MCHT_TP_GRP, a.CITY_CODE_USE_FLAG, a.CITY_CODE,a.MCHT_MODE_USE_FLAG,a.MCHT_MODE,");
        sql.append(" a.MCHT_NO_USE_FLAG, a.MCHT_NO, a.INST_CODE,a.CRT_OPR,a.UPD_OPR,");
        sql.append(" a.CRT_TS, a.UPD_TS ");
        sql.append(" FROM TBL_TXN_ROUTE_CTL a ");
        sql.append(" WHERE 1 = 1 ");
        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        if (params != null)
            for (Map.Entry<String, String> entry : params.entrySet())
              SqlUtils.setParameterLike(query, entry.getKey(), entry.getValue());

        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());
        query = this.getCurrentSession().createSQLQuery("SELECT COUNT(1) FROM (" + sql.toString() +")");
        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
	}

	@Override
	protected Class<?> getClasses() {
		return PassageControlInfo.class;
	}
	


}
