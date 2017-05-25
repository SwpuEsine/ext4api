package zft.control.manager.service;

import zft.control.manager.entity.SysParam;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;

public interface SysParamService {

    SysParam get(String key) throws Exception;
    List<SysParam> getGroup(String groupId);

    void edit(SysParam param) throws Exception;

    void add(SysParam param) throws Exception;
    List<SysParam> findAll() throws Exception;

    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String key, String name, String groupName);

    void refshCache() throws Exception;
}
