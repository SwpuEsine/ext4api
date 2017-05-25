package zft.control.manager.service;

import java.util.List;
import java.util.Map;

import zft.control.manager.entity.PassageControlInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.entity.PassageMsgInfo;
import zft.control.manager.objs.view.GridListRes;

public interface PassageMsgService {
    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params);

    List<PassageMsgInfo> findAll() throws Exception;

    PassageMsgInfo get(String brhId) throws Exception;

    void add(PassageMsgInfo passageMsgInfo) throws Exception;

    void del(String brhId) throws Exception;

    void update(PassageMsgInfo passageMsgInfo) throws Exception;
}
