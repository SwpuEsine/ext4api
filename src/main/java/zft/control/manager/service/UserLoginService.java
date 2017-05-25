package zft.control.manager.service;

import zft.control.manager.entity.UserInfo;

import java.util.List;

public interface UserLoginService {

    UserInfo getUserInfo(String userId) throws Exception;

    String checkUser(String userId, String userPwd, String verify) throws Exception;

    List<String> getUserMenu(Integer roleId) throws Exception;
}
