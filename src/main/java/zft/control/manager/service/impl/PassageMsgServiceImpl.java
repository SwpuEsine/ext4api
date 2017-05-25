package zft.control.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.dao.PassageMsgInfoDao;
import zft.control.manager.entity.PassageMsgInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.PassageCostService;
import zft.control.manager.service.PassageMsgService;
@Service("passageMsgService")
public class PassageMsgServiceImpl implements PassageMsgService {


    @Autowired
    private PassageMsgInfoDao passageMsgInfoDao;

    @Autowired
    private MenuInfDao menuInfDao;


	@Override
	public PassageMsgInfo get(String brhId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(PassageMsgInfo passageMsgInfo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(String brhId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(PassageMsgInfo passageMsgInfo) throws Exception {
		// TODO Auto-generated method stub

	}


	@Override
	public List<PassageMsgInfo> findAll() throws Exception {
		
		return passageMsgInfoDao.findAll();
	}


	@Override
	public GridListRes<Map<String, Object>> findList(Integer offset,
			Integer limit, Map<String, String> params) {
		return passageMsgInfoDao.findList(offset, limit, params);
	}

}
