package zft.control.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zft.control.manager.dao.SettleInsInfDao;
import zft.control.manager.entity.SettleInsInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.SettleInsInfService;
import zft.control.manager.tools.Tools;

/**
 * 通道管理业务逻辑层实现类
 * 
 * @author qianpyn
 *
 */
@Service("settleInsService")
@Transactional
public class SettleInsServiceImpl implements SettleInsInfService {

	@Autowired
	private SettleInsInfDao settleInsInfDao;

	@Override
	public SettleInsInf get(String stlmId) throws Exception {

		return settleInsInfDao.get(stlmId);
	}

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, String stlmID, String descr, String useFlag)
			throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("stlmId", stlmID);
		params.put("descr", descr);
		params.put("useFlag", useFlag);

		return settleInsInfDao.findList(offset, limit, params);
	}

	@Override
	public void save(SettleInsInf entity) throws Exception {
		String now = Tools.getDateTime();
		entity.setRecUpdTs(now);
		entity.setRecCrtTs(now);
		entity.setLastOperIn("1");
		settleInsInfDao.save(entity);
	}

	@Override
	public void update(SettleInsInf entity) throws Exception {
		SettleInsInf settleInsInf = settleInsInfDao.get(entity.getStlmId());
		String now = Tools.getDateTime();
		entity.setRecUpdTs(now);
		BeanUtils.copyProperties(entity, settleInsInf,
				Tools.getNullPropertyNames(entity));
		settleInsInfDao.update(settleInsInf);
	}

	@Override
	public void delete(String id) throws Exception {
		settleInsInfDao.delete(id);

	}

}
