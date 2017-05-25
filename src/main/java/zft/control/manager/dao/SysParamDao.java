package zft.control.manager.dao;

import zft.control.manager.entity.SysParam;

import java.util.List;

public interface SysParamDao extends GenericDao<SysParam, String>,GridBaseDao {

    List<SysParam> getGroup(String groupId);
}