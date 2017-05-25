package zft.control.manager.service;

import zft.control.manager.entity.BrhInfo;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;

/**
 * Created by work on 2017/5/22.
 */
public interface BrhInfoService {
    /**
     *
     * @param offset
     * @param limit
     * @param brhId
     * @param brhName  名称
     * @param brhType  类型
     * @param brhSta   状态
     * @return
     */
    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit,
                                              String brhId, String brhName, String brhType, String brhSta);

    List<BrhInfo> findAll() throws Exception;

    BrhInfo get(String brhId) throws Exception;

    void add(BrhInfo brhInfo) throws Exception;

    void del(String brhId) throws Exception;

    void update(BrhInfo brhInfo) throws Exception;
}
