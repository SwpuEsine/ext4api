package zft.control.manager.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import zft.control.manager.dao.PassageMsgInfoDao;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.entity.PassageMsgInfo;
import zft.control.manager.objs.view.GridListRes;
@Repository("passageMsgInfoDao")
public class PassageMsgInfoDaoImpl extends GenericBase<PassageMsgInfo, Integer> implements PassageMsgInfoDao {

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
		   StringBuffer sql = new StringBuffer();
	        sql.append(" SELECT a.INST_CODE, a.INST_NAME, a.INST_STAT, a.SRV_ID, a.CHG_FLAG, a.X_MCHT_NO, ");
	        sql.append(" a.X_TERM_ID, a.X_BRH_CODE, a.DAY_TOT_MAX_AMT, a.MON_TOT_MAX_AMT, a.RISK_CTL_TYPE, a.RISK_MAX_TXN_AMT, a.RISK_DAY_TXN_NUM, a.RISK_DAY_TXN_AMT, ");
	        sql.append(" a.OVERRUN_FLAG ");
	        sql.append(" FROM TBL_INS_INF a ");
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
		// TODO Auto-generated method stub
		return PassageMsgInfo.class;
	}

	
}
