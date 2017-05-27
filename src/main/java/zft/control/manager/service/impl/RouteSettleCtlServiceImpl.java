package zft.control.manager.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zft.control.manager.dao.RouteSettleCtlDao;
import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.RouteSettleCtlService;
import zft.control.manager.tools.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by work on 2017/5/24.
 */
@Transactional
@Service("routeSettleCtlService")
public class RouteSettleCtlServiceImpl implements RouteSettleCtlService {

    @Autowired
    private RouteSettleCtlDao routeSettleCtlDao;

    @Override
    public RouteSettleCtl get(String id) throws Exception {
        return routeSettleCtlDao.get(id);
    }

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String id, String routeName, String routeCtlId, String routeCtlSta) throws Exception {
        Map<String, String > params = new HashMap<>();
        params.put("id", id);
        params.put("routeName", routeName);
        params.put("routeCtlId", routeCtlId);
        params.put("routeCtlSta", routeCtlSta);
        return routeSettleCtlDao.findList(offset, limit, params);
    }

    @Override
    public List<RouteSettleCtl> findAll() throws Exception {
        return routeSettleCtlDao.findAll();
    }

    @Override
    public void save(RouteSettleCtl entity) throws Exception {
        String now = Tools.getDateTime();
        entity.setRecUpdTs(now);
        entity.setRecCrtTs(now);
        routeSettleCtlDao.save(entity);
    }

    @Override
    public void update(RouteSettleCtl entity) throws Exception {
        RouteSettleCtl edit = routeSettleCtlDao.get(entity.getId());
        String now = Tools.getDateTime();
        entity.setRecUpdTs(now);
        BeanUtils.copyProperties(entity, edit, Tools.getNullPropertyNames(entity));
        routeSettleCtlDao.update(edit);
    }

    @Override
    public void delete(String id) throws Exception {
        routeSettleCtlDao.delete(id);
    }

    @Override
    public boolean check(String id) throws Exception {
        return get(id) == null;
    }
}
