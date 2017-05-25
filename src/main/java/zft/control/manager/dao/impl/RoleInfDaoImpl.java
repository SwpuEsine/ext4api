package zft.control.manager.dao.impl;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.RoleInfDao;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.Map;

@Repository("roleInfDao")
public class RoleInfDaoImpl extends GenericBase<RoleInf, Integer> implements RoleInfDao {

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer("select a.role_id,a.role_name from tbl_role_inf a  where 1=1 ");
        SqlUtils.addSql(sql, "a.role_name like :roleName", params.get("roleName"));
        sql.append(" order by a.role_name asc ");
        Query query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        SqlUtils.setParameterLike(query, "roleName", params.get("roleName"));

        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("select count(*) FROM (" + sql.toString() + ") ");
        SqlUtils.setParameterLike(query, "roleName", params.get("roleName"));

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }

    @Override
    protected Class<?> getClasses() {
        return RoleInf.class;
    }
}
