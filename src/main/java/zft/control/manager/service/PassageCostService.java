package zft.control.manager.service;

import zft.control.manager.entity.BrhInfo;
import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;


public interface PassageCostService {

    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params);

    List<PassageCostInfo> findAll() throws Exception;

    PassageCostInfo get(String brhId) throws Exception;

    void add(PassageCostInfo passageCostInfo) throws Exception;

    void del(String brhId) throws Exception;

    void update(PassageCostInfo passageCostInfo) throws Exception;
}
