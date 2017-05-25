package zft.control.manager.service;

import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;

import java.util.List;
import java.util.Map;

public interface UserInfService {

    List<UserInfo> findAll() throws Exception;

    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String nickName, String tel, String userStatus);

    UserInfo get(String menuId) throws Exception;

    void edit(UserInfo userInf) throws Exception;

    void add(UserInfo userInf) throws Exception;

    ResponseBase reset(String userId, String userPwd) throws Exception;

    boolean check(String userId) throws Exception;

    void delete(String userId) throws Exception;

}
