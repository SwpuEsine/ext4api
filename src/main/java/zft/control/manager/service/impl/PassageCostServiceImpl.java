package zft.control.manager.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.dao.PassageCostInfDao;
import zft.control.manager.dao.RoleInfDao;
import zft.control.manager.entity.BrhInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.PassageCostService;
import zft.control.manager.service.RoleInfoService;
@Service("passageCostService")
public class PassageCostServiceImpl implements PassageCostService {


    @Autowired
    private PassageCostInfDao passageCostInfDao;

    @Autowired
    private MenuInfDao menuInfDao;


	@Override
	public PassageCostInfo get(String brhId) throws Exception {
		// TODO Auto-generated method stub
		return passageCostInfDao.get(Integer.parseInt(brhId));
	}

	@Override
	public void add(PassageCostInfo passageCostInfo) throws Exception {
		passageCostInfDao.save(passageCostInfo);

	}

	@Override
	public void del(String brhId) throws Exception {
		// TODO Auto-generated method stub
		passageCostInfDao.delete(Integer.parseInt(brhId));
	}

	@Override
	public void update(PassageCostInfo passageCostInfo) throws Exception {
		passageCostInfDao.update(passageCostInfo);
	}


	@Override
	public List<PassageCostInfo> findAll() throws Exception {
		
		return passageCostInfDao.findAll();
	}


	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
		return passageCostInfDao.findList(offset, limit, params);
	}

}
