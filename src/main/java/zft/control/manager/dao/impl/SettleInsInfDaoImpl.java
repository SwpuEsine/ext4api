package zft.control.manager.dao.impl;

import org.springframework.stereotype.Repository;
import zft.control.manager.dao.SettleInsInfDao;
import zft.control.manager.entity.SettleInsInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.Map;

/**
 * Created by work on 2017/5/25.
 */
@Repository("settleInsInfDao")
public class SettleInsInfDaoImpl extends GenericBase<SettleInsInf, String> implements SettleInsInfDao{

    @Override
    protected Class<?> getClasses() {
        return SettleInsInf.class;
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT                        ");
        sql.append(" REC_CRT_TS          ,         ");
        sql.append(" STLM_ID             ,         ");
        sql.append(" DESCR               ,         ");
        sql.append(" USE_FLAG            ,         ");
        sql.append(" RESERVE1            ,         ");
        sql.append(" RESERVE2            ,         ");
        sql.append(" RESERVE3            ,         ");
        sql.append(" LAST_OPER_IN        ,         ");
        sql.append(" UPD_USR_ID          ,         ");
        sql.append(" REC_UPD_TS                    ");
        sql.append(" FROM TBL_SETTLE_INS_INF t     ");
        sql.append(" WHERE 1 = 1 ");

        SqlUtils.addSql(sql, " t.STLM_ID like :stlmId", params.get("stlmId"));
        SqlUtils.addSql(sql, " a.DESCR like :descr", params.get("descr"));
        SqlUtils.addSql(sql, " a.USE_FLAG like :useFlag ", params.get("useFlag"));
        sql.append(" ORDER BY UPD_USR_ID")
        return null;
    }
}
