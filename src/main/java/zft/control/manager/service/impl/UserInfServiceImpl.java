package zft.control.manager.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.dao.UserInfDao;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.UserInfService;
import zft.control.manager.tools.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userInfService")
public class UserInfServiceImpl implements UserInfService {

    @Autowired
    private UserInfDao userInfDao;

    @Autowired
    private RedisService redisService;

    @Override
    public List<UserInfo> findAll() throws Exception {
        return userInfDao.findAll();
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String name, String userId, String userStatus) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("userId", userId);
        params.put("userStatus", userStatus);
        return userInfDao.findList(offset, limit, params);
    }

    @Override
    public UserInfo get(String id) throws Exception {
        return userInfDao.get(id);
    }

    @Override
    public void edit(UserInfo userInf) throws Exception {
        UserInfo edit = get(userInf.getUserId());
        BeanUtils.copyProperties(userInf, edit, Tools.getNullPropertyNames(userInf));
        userInfDao.update(edit);
    }

    @Override
    public void add(UserInfo userInf) throws Exception {
        userInf.setCrtTs(Tools.getDateTime());
        userInf.setUserStatus("0");
        userInfDao.save(userInf);
    }

    @Override
    public ResponseBase reset(String userId, String userPwd) throws Exception {
        UserInfo reset = userInfDao.get(userId);
        reset.setPasswd(userPwd);
        userInfDao.saveOrUpdate(reset);
        ResponseBase base = new ResponseBase("000000", "密码重置成功，默认密码：111111");
        return base;
    }

    public boolean check(String userId) throws Exception {
        UserInfo check = userInfDao.get(userId);
        if (check != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void delete(String userId) throws Exception {
        userInfDao.delete(userId);
    }

}
