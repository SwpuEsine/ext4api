package zft.control.manager.service;

import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;

public interface RoleInfoService {

    List<RoleInf> findAll() throws Exception;

    GridListRes<Map<String, Object>> findLike(Integer offset, Integer limit, String roleName);

    RoleInf get(Integer menuId) throws Exception;

    void edit(Integer roleId, String roleName, String roleMenu) throws Exception;

    void add(String roleName, String roleMenu) throws Exception;

    void delete(Integer menuId) throws Exception;

    List<MenuInfo> getMenuAll() throws Exception;
}
