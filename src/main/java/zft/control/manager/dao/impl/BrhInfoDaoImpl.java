package zft.control.manager.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.BrhInfoDao;
import zft.control.manager.entity.BrhInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.Map;


@Repository("brhInfoDao")
public class BrhInfoDaoImpl extends GenericBase<BrhInfo, String> implements BrhInfoDao {

    @Override
    protected Class<?> getClasses() {
        return BrhInfo.class;
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT a.brh_id, a.cup_brh_id, a.brh_type, a.brh_level, a.brh_sta, a.up_brh_id, ");
        sql.append(" a.reg_dt, a.post_cd, a.brh_addr, a.brh_name, a.brh_tel_no, a.brh_cont_name, a.resv1 ");
        sql.append(" FROM tbl_brh_info a ");
        sql.append(" WHERE 1 = 1 ");

        SqlUtils.addSql(sql, " a.brh_id like :brhId", params.get("brhId"));
        SqlUtils.addSql(sql, " a.brh_name like :brhName", params.get("brhName"));
        SqlUtils.addSql(sql, " a.brh_type like :brhType ", params.get("brhType"));
        SqlUtils.addSql(sql, " a.brh_sta like :brhSta ", params.get("brhSta"));

        sql.append(" ORDER BY brh_id ");

        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        setQueryParams(query, params);
        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("SELECT COUNT(1) FROM (" + sql.toString() +")");
        setQueryParams(query, params);

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }

    private void setQueryParams(SQLQuery query, Map<String, String> params) {
        SqlUtils.setParameterLike(query, "brhId", params.get("brhId"));
        SqlUtils.setParameterLike(query, "brhName", params.get("brhName"));
        SqlUtils.setParameterLike(query, "brhType", params.get("brhType"));
        SqlUtils.setParameterLike(query, "brhSta", params.get("brhSta"));
    }
}
