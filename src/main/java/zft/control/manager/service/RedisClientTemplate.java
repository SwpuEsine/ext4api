package zft.control.manager.service;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface RedisClientTemplate {

    Long sadd(String key, String... value);

    Long srem(String key, String... members);

    Set<String> smembers(String key);

    Boolean sismember(String key, String value);

    Long scard(String key);

    Long lpush(String key, String... value);

    String rpop(String key);

    Long llen(String key);

    String ltrim(String key, int start, int end);

    String lindex(String key, int index);

    interface MAP {
        String APP_LOGIN_ID = "APP_LOGIN_ID";
    }

    String set(String key, String value);

    String get(String key);

    Long hdel(String key, String... fields);

    Boolean exists(String key);

    Long del(String key);

    String type(String key);

    Long expire(String key, int seconds);

    Map<String, String> hgetAll(String key);

    String hget(String key, String filed);

    Long hset(String key, String filed, String value);

    Long persist(String key);
    
    List<String> lrange(String key,int start,int end);

}
