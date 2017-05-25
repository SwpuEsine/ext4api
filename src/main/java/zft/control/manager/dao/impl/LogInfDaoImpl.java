package zft.control.manager.dao.impl;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.LogInfDao;
import zft.control.manager.entity.SysLogInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.Map;

@Repository("logInfDao")
public class LogInfDaoImpl extends GenericBase<SysLogInf, Long> implements LogInfDao {

    @Override
    protected Class<?> getClasses() {
        return SysLogInf.class;
    }


    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer("select getusername(a.opr_id) as opr_name,c.menu_name||'-'||b.menu_name" +
                " as menu_name,a.opr_url,a.opr_ts from sys_log_inf a left join tbl_menu_inf b on a.opr_url = b.menu_url" +
                " left join  tbl_menu_inf c on b.super_id=c.menu_id where 1=1 ");

        SqlUtils.addSql(sql, "a.opr_url like :oprUrl ", params.get("oprUrl"));
        SqlUtils.addSql(sql, "a.opr_id=:oprId ", params.get("oprId"));
        params.put("endDate", SqlUtils.addBSql(sql, "substr(a.opr_ts,0,8) BETWEEN :startDate AND :endDate  ",
                params.get("startDate"), params.get("endDate")));

        Query query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        SqlUtils.setParameterLike(query, "oprUrl", params.get("oprUrl"));
        SqlUtils.setParameter(query, "oprId", params.get("oprId"));
        SqlUtils.setParameter(query, "startDate", params.get("startDate"));
        SqlUtils.setParameter(query, "endDate", params.get("endDate"));

        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("select count(*) FROM (" + sql.toString() + ") ");
        SqlUtils.setParameterLike(query, "oprUrl", params.get("oprUrl"));
        SqlUtils.setParameter(query, "oprId", params.get("oprId"));
        SqlUtils.setParameter(query, "startDate", params.get("startDate"));
        SqlUtils.setParameterLike(query, "endDate", params.get("endDate"));

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }
}
