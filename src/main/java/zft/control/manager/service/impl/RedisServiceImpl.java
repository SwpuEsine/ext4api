package zft.control.manager.service.impl;

import com.alibaba.fastjson.JSON;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.SysParam;
import zft.control.manager.service.MenuInfoService;
import zft.control.manager.service.RedisClientTemplate;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.tools.Constants;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisClientTemplate redisClientTemplate;
    @Autowired
    private SysParamService sysParamService;

    @Autowired
    private MenuInfoService menuInfoService;

    @Override
    public String get(String key) {
        return redisClientTemplate.get(key);
    }

    @Override
    public Boolean exists(String key) {
        return redisClientTemplate.exists(key);
    }

    @Override
    public void expire(String key, int seconds) {
        redisClientTemplate.expire(key, seconds);
    }

    @Override
    public void set(String key, String value) {
        redisClientTemplate.set(key, value);
    }

    @Override
    public void del(String key) {
        redisClientTemplate.del(key);
    }

    @Override
    public void hset(String key, String filed, String value) {
        redisClientTemplate.hset(key, filed, value);
    }

    @Override
    public String hget(String key, String filed) {
        return redisClientTemplate.hget(key, filed);
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        return redisClientTemplate.hgetAll(key);
    }

    /**
     * 获取指定key下的map分组
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> nameValMap(String key) {
        return hgetAll("nameVal" + key);
    }

    /**
     * 获取指定key下的map分组
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> valNameMap(String key) {
        return hgetAll("valName" + key);
    }

    @Override
    public void initAll() throws Exception {
        initParam();
        initMenuInf();
    }

    /**
     * 增加系统参数指定分组
     */
    @Override
    public void setSysparams(String groupId) {
        List<SysParam> groupAll = sysParamService.getGroup(groupId);
        for (SysParam sys : groupAll) {
            redisClientTemplate.hset(sys.getGroupId(), sys.getKey(), sys.getValue());
            redisClientTemplate.hset("valName" + sys.getGroupId(), sys.getValue(), sys.getName());
            redisClientTemplate.hset("nameVal" + sys.getGroupId(), sys.getName(), sys.getValue());
        }
    }

    /**
     * 移出系统参数指定分组
     *
     * @param groupId
     */
    @Override
    public void removeSysparams(String groupId) {
        redisClientTemplate.del("valName" + groupId);
        redisClientTemplate.del("nameVal" + groupId);
        redisClientTemplate.del(groupId);
    }

    /**
     * 参数表加载
     *
     * @throws Exception
     */
    @Override
    public void initParam() throws Exception {
        List<SysParam> all = sysParamService.findAll();
        for (SysParam sys : all) {
            removeSysparams(sys.getGroupId());
        }

        for (SysParam sys : all) {
            redisClientTemplate.hset(sys.getGroupId(), sys.getKey(), sys.getValue());
            redisClientTemplate.hset("valName" + sys.getGroupId(), sys.getValue(), sys.getName());
            redisClientTemplate.hset("nameVal" + sys.getGroupId(), sys.getName(), sys.getValue());
        }
    }

    /**
     * 菜单表加载
     *
     * @throws Exception
     */
    @Override
    public void initMenuInf() throws Exception {
        List<MenuInfo> all = menuInfoService.findAll();
        for (MenuInfo m : all) {
            redisClientTemplate.hset(Constants.RedisKey.MENU_CACHE, m.getMenuId() + "", JSON.toJSONString(m));
        }
    }


    @Override
    public void setLoginUser(String userId) {
        if (redisClientTemplate.scard(RedisClientTemplate.MAP.APP_LOGIN_ID) == 0) {
            expire(RedisClientTemplate.MAP.APP_LOGIN_ID, 16 * 60 * 60);
        }
        redisClientTemplate.sadd(RedisClientTemplate.MAP.APP_LOGIN_ID, userId);
    }

    @Override
    public Set<String> getLoginUser() {
        return redisClientTemplate.smembers(RedisClientTemplate.MAP.APP_LOGIN_ID);
    }


    @Override
    public void delLoginUser(String userId) {
        redisClientTemplate.srem(RedisClientTemplate.MAP.APP_LOGIN_ID, userId);
    }

    @Override
    public Long scard(String key) {
        return redisClientTemplate.scard(key);
    }

    @Override
    public Long hdel(String key, String... fields) {
        return redisClientTemplate.hdel(key, fields);
    }
}