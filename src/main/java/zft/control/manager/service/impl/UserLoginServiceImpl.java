package zft.control.manager.service.impl;

import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.dao.RoleInfDao;
import zft.control.manager.dao.UserInfDao;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.service.UserLoginService;
import zft.control.manager.tools.SystemFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserInfDao userInfDao;
    @Autowired
    private RoleInfDao roleInfDao;

    @Autowired
    private MenuInfDao menuInfDao;

    @Override
    public UserInfo getUserInfo(String userId) throws Exception {
        UserInfo userInf = userInfDao.get(userId);
        return userInf;
    }

    @Override
    public String checkUser(String userId, String userPwd, String verify) throws Exception {
        UserInfo userInf = userInfDao.get(userId);
        if (userInf == null || !userPwd.equals(userInf.getPasswd())) {
            return SystemFiles.getCode("000005");
        }
        return null;
    }

    @Override
    public List<String> getUserMenu(Integer roleId) throws Exception {
        RoleInf roleInf = roleInfDao.get(roleId);
        return menuInfDao.getMenuUrl(roleInf.getRoleMenu());
    }

}
