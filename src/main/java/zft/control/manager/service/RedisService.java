package zft.control.manager.service;

import java.util.Map;
import java.util.Set;

public interface RedisService {

    String get(String key);

    Boolean exists(String key);

    void expire(String key, int seconds);

    void set(String key, String value);

    void del(String key);

    void hset(String key, String filed, String value);

    String hget(String key, String filed);

    Map<String, String> hgetAll(String key);
    Map<String, String> nameValMap(String key);

    Map<String, String> valNameMap(String key);

    void initAll() throws Exception;

    void setSysparams(String groupId);

    void removeSysparams(String groupId);

    void initParam() throws Exception;

    void initMenuInf() throws Exception;

    void setLoginUser(String userId);

    /**
     * 获取loginUser
     *
     * @return
     */
    Set<String> getLoginUser();

    void delLoginUser(String userId);

    Long scard(String key);

    Long hdel(String key, String... fields);
}
