package zft.control.manager.dao.impl;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository("menuInfoDao")
public class MenuInfDaoImpl extends GenericBase<MenuInfo, Integer> implements MenuInfDao {

    @Override
    protected Class<?> getClasses() {
        return MenuInfo.class;
    }

    @Override
    public List<String[]> getSuperId() {
        String sql = "select t.menu_id,t.menu_name from tbl_menu_inf t where t.URL_LEVEL IN (1,2)";
        List<String[]> query = this.getCurrentSession().createSQLQuery(sql).list();
        return query;
    }

    @Override
    public List<String> getMenuUrl(String roleMenu) {
        String hql = "select t.menu_url from tbl_menu_inf t where t.menu_id in (" + roleMenu + ") ";
        Query query = this.getCurrentSession().createSQLQuery(hql);
        Iterator results = query.list().iterator();
        List<String> listRes = new ArrayList<>();
        while (results.hasNext()) {
            Object val = results.next();
            if (val == null)
                continue;
            listRes.add(val.toString());
        }
        return listRes;
    }


    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer("select c.su_name,c.menu_id,c.menu_name,c.menu_url,c.super_id from (select b.menu_name su_name," +
                " a.menu_id,a.menu_name,a.menu_url,a.super_id from tbl_menu_inf a left join tbl_menu_inf b on a.super_id = b.menu_id ) c where 1=1 ");

        SqlUtils.addSql(sql, "c.menu_name like :menuName", params.get("menuName"));
        SqlUtils.addSql(sql, " c.menu_url like :menuUrl ", params.get("menuUrl"));
        SqlUtils.addSql(sql, " c.su_name like :suName ", params.get("suName"));
        sql.append(" order by c.su_name asc ");
        Query query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        SqlUtils.setParameterLike(query, "menuName", params.get("menuName"));
        SqlUtils.setParameterLike(query, "menuUrl", params.get("menuUrl"));
        SqlUtils.setParameterLike(query, "suName", params.get("suName"));


        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());

        query = this.getCurrentSession().createSQLQuery("select count(*) FROM (" + sql.toString() + ") ");
        SqlUtils.setParameterLike(query, "menuName", params.get("menuName"));
        SqlUtils.setParameterLike(query, "menuUrl", params.get("menuUrl"));
        SqlUtils.setParameterLike(query, "suName", params.get("suName"));

        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
    }
}
