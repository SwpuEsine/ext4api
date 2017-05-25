package zft.control.manager.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import zft.control.manager.dao.SelectDao;
import zft.control.manager.objs.view.SelectArray;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.SystemFiles;


@Repository("selectService")
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;

    @Autowired
    private RedisService redisService;

    @Override
    public SelectArray userSelect(Integer page, String id, String text) {
        String table = " user_info a ";
        String[] columns = {"a.user_id", "a.name"};

        String cacheKey = (table + page + id + text);
        if (redisService.exists(cacheKey)) {//取缓存数据
            return JSON.parseObject(redisService.get(cacheKey), SelectArray.class);
        }
        SelectArray selectArray = selectDao.getSelect(table, columns, page, id, text);
        redisService.set(cacheKey, JSON.toJSONString(selectArray));
        redisService.expire(cacheKey, Constants.SELECT_CACHE);
        return selectArray;
    }

}
