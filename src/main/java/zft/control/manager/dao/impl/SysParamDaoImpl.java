package zft.control.manager.dao.impl;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.SysParamDao;
import zft.control.manager.entity.SysParam;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.List;
import java.util.Map;

@Repository("sysParamDao")
public class SysParamDaoImpl extends GenericBase<SysParam, String> implements SysParamDao {

    @Override
    public List<SysParam> getGroup(String groupId) {
        StringBuffer sql = new StringBuffer("select t from SysParam t where 1=1 ");
        SqlUtils.addSql(sql, " t.groupId =:groupId ", groupId);
        Query query = this.getCurrentSession().createQuery(sql.toString());
        SqlUtils.setParameter(query, "groupId", groupId);
        return query.list();
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer(" select t.key,t.group_id,t.group_name,t.name,t.value from sys_param t  where 1=1  ");
        SqlUtils.addSql(sql, "t.key =:key", params.get("key"));
        SqlUtils.addSql(sql, "t.name like :name ", params.get("name"));
        SqlUtils.addSql(sql, " t.group_Name  like :groupName ", params.get("groupName"));

        Query query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        SqlUtils.setParameter(query, "key", params.get("key"));
        SqlUtils.setParameterLike(query, "name", params.get("name"));
        SqlUtils.setParameterLike(query, "groupName", params.get("groupName"));

        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("select count(*) FROM (" + sql.toString() + ") ");
        SqlUtils.setParameter(query, "key", params.get("key"));
        SqlUtils.setParameterLike(query, "name", params.get("name"));
        SqlUtils.setParameterLike(query, "groupName", params.get("groupName"));

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }

    @Override
    protected Class<?> getClasses() {
        return SysParam.class;
    }
}
