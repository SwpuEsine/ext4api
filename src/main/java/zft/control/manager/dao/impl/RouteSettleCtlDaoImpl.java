package zft.control.manager.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.RouteSettleCtlDao;
import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by work on 2017/5/24.
 */
@Repository("routeSettleCtlDao")
public class RouteSettleCtlDaoImpl extends GenericBase<RouteSettleCtl, String> implements RouteSettleCtlDao {

    @Override
    protected Class<?> getClasses() {
        return RouteSettleCtl.class;
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                                                                                     ");
        sql.append(" 	t.ID, t.ROUTE_NAME, t.ROUTE_CTL_ID, t.ROUTE_CTL_STA, t.ISSUER_USE_FLAG , t.STLM_TYPE    ");
        //sql.append(" 	, t.ISSUER_CD, t.TXN_AMT_USE_FLAG, t.MIN_TXN_AMT, t.MAX_TXN_AMT, t.CITY_CODE_USE_FLAG   ");
        //sql.append(" 	, t.CITY_CODE, t.MCHT_NO_USE_FLAG, t.MCHT_NO, t.STLM_TYPE_USE_FLAG         ");
        //sql.append(" 	, t.CARD_BIN_USE_FLAG, t.CARD_BIN, t.RESERVE1_USE_FLAG, t.RESERVE1, t.RESERVE2_USE_FLAG ");
        //sql.append(" 	, t.RESERVE2, t.RESERVE3_USE_FLAG, t.RESERVE3                              ");
        sql.append(" 	, t.UPD_USR_ID, t.REC_UPD_TS, t.REC_CRT_TS , t.LAST_OPER_IN, t.INST_CODE                             ");
        sql.append(" FROM TBL_ROUTE_SETTLE_CTL t                                                                ");

        sql.append(" WHERE 1 = 1 ");
        sql.append(" ORDER BY t.REC_UPD_TS ");

        SqlUtils.addSql(sql, " t.ID like :ID", params.get("id"));
        SqlUtils.addSql(sql, " t.ROUTE_NAME like :ROUTE_NAME", params.get("routeName"));
        SqlUtils.addSql(sql, " t.ROUTE_CTL_STA like :ROUTE_CTL_STA ", params.get("routeCtlSta"));
        SqlUtils.addSql(sql, " t.ROUTE_CTL_ID like :ROUTE_CTL_ID ", params.get("routeCtlId"));

        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        SqlUtils.setParameterLike(query, "id", params.get("id"));
        SqlUtils.setParameterLike(query, "routeName", params.get("routeName"));
        SqlUtils.setParameterLike(query, "routeCtlSta", params.get("routeCtlSta"));
        SqlUtils.setParameterLike(query, "routeCtlId", params.get("routeCtlId"));
        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("SELECT COUNT(1) FROM (" + sql.toString() +")");
        SqlUtils.setParameterLike(query, "id", params.get("id"));
        SqlUtils.setParameterLike(query, "routeName", params.get("routeName"));
        SqlUtils.setParameterLike(query, "routeCtlSta", params.get("routeCtlSta"));
        SqlUtils.setParameterLike(query, "routeCtlId", params.get("routeCtlId"));

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }
}
