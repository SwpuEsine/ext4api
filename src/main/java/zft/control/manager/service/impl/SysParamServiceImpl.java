package zft.control.manager.service.impl;

import zft.control.manager.dao.SysParamDao;
import zft.control.manager.entity.SysParam;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.SysParamService;
import zft.control.manager.tools.Tools;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysParamService")
public class SysParamServiceImpl implements SysParamService {

    @Autowired
    private SysParamDao sysParamDao;
    @Autowired
    private RedisService redisService;

    @Override
    public SysParam get(String key) throws Exception {
        return sysParamDao.get(key);
    }

    @Override
    public List<SysParam> getGroup(String groupId) {
        return sysParamDao.getGroup(groupId);
    }

    @Override
    public void edit(SysParam param) throws Exception {
        SysParam sys = get(param.getKey());
        BeanUtils.copyProperties(param, sys, Tools.getNullPropertyNames(param));
        sysParamDao.update(sys);
        redisService.removeSysparams(param.getGroupId());
        redisService.setSysparams(sys.getGroupId());
    }

    @Override
    public void add(SysParam param) throws Exception {
        sysParamDao.save(param);
        redisService.removeSysparams(param.getGroupId());
        redisService.setSysparams(param.getGroupId());
    }

    @Override
    public List<SysParam> findAll() throws Exception {
        return sysParamDao.findAll();
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String key, String name, String groupName) {
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        params.put("name", name);
        params.put("groupName", groupName);
        return sysParamDao.findList(offset, limit, params);
    }

    @Override
    public void refshCache() throws Exception {
        redisService.initAll();
    }

}