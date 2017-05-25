package zft.control.manager.service;


import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.objs.view.GridListRes;

import java.util.List;
import java.util.Map;

public interface RouteSettleCtlService {

    RouteSettleCtl get(String id) throws Exception;

    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit,
                                              String id, String routeName, String routeCtlId, String routeCtlSta)
                                            throws Exception;

    List<RouteSettleCtl> findAll() throws Exception;

    void save(RouteSettleCtl entity) throws Exception;

    void update(RouteSettleCtl entity) throws Exception;

    void delete(String id) throws Exception;

}
