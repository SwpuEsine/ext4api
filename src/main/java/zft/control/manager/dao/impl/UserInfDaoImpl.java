package zft.control.manager.dao.impl;

import org.hibernate.SQLQuery;
import org.springframework.jdbc.object.SqlQuery;
import zft.control.manager.dao.UserInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userInfDao")
public class UserInfDaoImpl extends GenericBase<UserInfo, String> implements UserInfDao {

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer("select a.user_id,a.tel,a.email,a.name,a.crt_ts,a.user_status, a.brh_id" +
                ",getrolename(a.role_id) role_id from user_info a where 1=1 ");

        SqlUtils.addSql(sql, " a.name like :name", params.get("name"));
        SqlUtils.addSql(sql, " a.user_id like :userId ", params.get("userId"));
        SqlUtils.addSql(sql, " a.user_status = :userStatus ", params.get("userStatus"));
        sql.append(" order by a.crt_ts desc ");
        Query query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        setQueryParams(query, params);

        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("select count(*) FROM (" + sql.toString() + ") ");
        setQueryParams(query, params);
        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }

    private void setQueryParams(Query query, Map<String, String> params){
        SqlUtils.setParameterLike(query, "name", params.get("name"));
        SqlUtils.setParameterLike(query, "userId", params.get("userId"));
        SqlUtils.setParameter(query, "userStatus", params.get("userStatus"));
    }

    @Override
    protected Class<?> getClasses() {
        return UserInfo.class;
    }
}
