package zft.control.manager.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.dao.BrhInfoDao;
import zft.control.manager.entity.BrhInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.BrhInfoService;
import zft.control.manager.tools.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by work on 2017/5/22.
 */

@Service("brhInfoService")
public class BrhInfoServiceImpl implements BrhInfoService {
    @Autowired
    private BrhInfoDao brhInfoDao;

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit,
                                                     String brhId, String brhName, String brhType, String brhSta) {
        Map<String, String> params = new HashMap();
        params.put("brhId", brhId);
        params.put("brhName", brhName);
        params.put("brhType", brhType);
        params.put("brhSta", brhSta);
        return brhInfoDao.findList(offset, limit, params);
    }

    @Override
    public List<BrhInfo> findAll() throws Exception {
        return brhInfoDao.findAll();
    }

    @Override
    public BrhInfo get(String brhId) throws Exception {
        return brhInfoDao.get(brhId);
    }

    @Override
    public void add(BrhInfo brhInfo) throws Exception {
        brhInfoDao.save(brhInfo);
    }

    @Override
    public void del(String brhId) throws Exception {
        brhInfoDao.delete(brhId);
    }

    @Override
    public void update(BrhInfo brhInfo) throws Exception {
        BrhInfo edit = get(brhInfo.getBrhId());
        BeanUtils.copyProperties(brhInfo, edit, Tools.getNullPropertyNames(brhInfo));
        brhInfoDao.update(edit);
    }

    @Override
    public boolean check(String brhId) throws Exception {
        BrhInfo brhInfo = get(brhId);
        return brhInfo==null;
    }
}
