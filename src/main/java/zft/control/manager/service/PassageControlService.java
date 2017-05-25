package zft.control.manager.service;

import java.util.List;
import java.util.Map;

import zft.control.manager.entity.PassageControlInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.objs.view.GridListRes;

public interface PassageControlService {
    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params);

    List<PassageControlInfo> findAll() throws Exception;

    PassageControlInfo get(String brhId) throws Exception;

    void add(PassageControlInfo passageControlInfo) throws Exception;

    void del(String brhId) throws Exception;

    void update(PassageControlInfo passageControlInfo) throws Exception;
}
