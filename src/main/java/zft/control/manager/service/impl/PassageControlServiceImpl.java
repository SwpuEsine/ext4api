package zft.control.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.dao.PassageControlInfDao;
import zft.control.manager.dao.PassageCostInfDao;
import zft.control.manager.entity.PassageControlInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.PassageControlService;
import zft.control.manager.service.PassageCostService;

@Service("passageControlService")
public class PassageControlServiceImpl implements PassageControlService{
    @Autowired
    private PassageControlInfDao passageControlInfDao;

	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
		return passageControlInfDao.findList(offset, limit, params);
	}

	@Override
	public List<PassageControlInfo> findAll() throws Exception {
		return passageControlInfDao.findAll();
	}

	@Override
	public PassageControlInfo get(String brhId) throws Exception {
		return passageControlInfDao.get(brhId);
	}

	@Override
	public void add(PassageControlInfo passageControlInfo) throws Exception {
		passageControlInfDao.save(passageControlInfo);
	}

	@Override
	public void del(String brhId) throws Exception {
		passageControlInfDao.delete(brhId);
	}

	@Override
	public void update(PassageControlInfo passageControlInfo) throws Exception {
		passageControlInfDao.update(passageControlInfo);
	}

}
