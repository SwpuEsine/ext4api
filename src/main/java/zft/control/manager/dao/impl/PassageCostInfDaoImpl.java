package zft.control.manager.dao.impl;

import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import zft.control.manager.dao.PassageCostInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.tools.SqlUtils;
@Repository("passageCostInfDao")
public class PassageCostInfDaoImpl extends GenericBase<PassageCostInfo, Integer> implements PassageCostInfDao {

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT a.DISC_CD, a.INST_CODE, a.FRI_IN, a.MCC, a.FEE_TYPE, a.FEE_FIXED, ");
        sql.append(" a.FLOOR_AMOUNT, a.UPPER_AMOUNT, a.FEE_MAX_AMT, a.FEE_MIN_AMT, a.FEE_RATE, a.DISC_DESC, a.CRT_OPR, a.UPD_OPR, ");
        sql.append(" a.CRT_TS, a.UPD_TS ");
        sql.append(" FROM TBL_DISC_ALGO a ");
        sql.append(" WHERE 1 = 1 ");
        if (params != null && !params.isEmpty())
            for (Map.Entry<String, String> entry : params.entrySet()){
            	if(entry.getValue()!=null && !entry.getValue().equals("")){
            		sql.append("and a."+entry.getKey()+" like '%"+entry.getValue()+"%' ");
            	}           	
            }              
        SQLQuery query = this.getCurrentSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setMaxResults(limit);
        query.setFirstResult(offset);       
        GridListRes<Map<String, Object>> res = new GridListRes<>();
        res.setRows(query.list());
        query = this.getCurrentSession().createSQLQuery("SELECT COUNT(1) FROM (" + sql.toString() +")");
        res.setTotal(Integer.parseInt(query.list().get(0).toString()));
        return res;
	}

	@Override
	protected Class<?> getClasses() {
		return PassageCostInfo.class;
	}
	


}
