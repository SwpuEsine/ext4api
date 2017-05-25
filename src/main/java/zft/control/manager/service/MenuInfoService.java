package zft.control.manager.service;

import zft.control.manager.entity.MenuInfo;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;

public interface MenuInfoService {

    List<MenuInfo> findAll() throws Exception;

    GridListRes<Map<String, Object>> findLike(Integer offset, Integer limit, String menuName, String menuUrl, String suName);

    MenuInfo get(Integer menuId) throws Exception;

    void edit(MenuInfo menuInfo) throws Exception;

    void add(MenuInfo menuInfo) throws Exception;

    List<String[]> getSuperId();

    void delete(Integer id) throws Exception;
}
