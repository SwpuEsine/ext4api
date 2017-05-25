package zft.control.manager.dao;

import zft.control.manager.entity.MenuInfo;

import java.util.List;

public interface MenuInfDao extends GenericDao<MenuInfo, Integer>, GridBaseDao {
    List<String[]> getSuperId();

    List<String> getMenuUrl(String roleMenu);
}
