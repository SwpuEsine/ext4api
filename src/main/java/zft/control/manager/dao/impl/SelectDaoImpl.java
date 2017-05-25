package zft.control.manager.dao.impl;

import zft.control.manager.dao.SelectDao;
import zft.control.manager.objs.view.SelectArray;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.SqlUtils;
import zft.control.manager.tools.Tools;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("selectDao")
public class SelectDaoImpl implements SelectDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public SelectArray getSelect(String tableName, String[] columns, Integer page, String id, String text) {
        StringBuffer sql = new StringBuffer(" SELECT DISTINCT " + columns[0] + " as ID, " + columns[1] + " as TEXT  FROM " + tableName + " WHERE 1 = 1 ");

        SqlUtils.addSql(sql, columns[0] + " IN (:inId)", id);
        SqlUtils.addSql(sql, columns[1] + " like :text ", text);


        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());

        SqlUtils.setParameterLike(query, "text", text);
        if (id != null)
            SqlUtils.setParameterList(query, "inId", id.split(","));

        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setFirstResult(page * Constants.SELECT_LIMIT);
        query.setMaxResults(Constants.SELECT_LIMIT);
        SelectArray select = new SelectArray();
        Tools.formatSelect(query.list(), select);
        select.setTotal(count(tableName, columns, text));
        select.setLimit(Constants.SELECT_LIMIT);
        return select;
    }

    private int count(String tableName, String[] columns, String text) {
        StringBuffer sql = new StringBuffer(" SELECT count(" + columns[0] + ")  FROM " + tableName + " WHERE 1 = 1 ");
        SqlUtils.addSql(sql, columns[1] + " like :text ", text);
        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());
        SqlUtils.setParameterLike(query, "text", text);
        List<Object> list = query.list();
        return Integer.parseInt(list.get(0).toString());
    }
}
