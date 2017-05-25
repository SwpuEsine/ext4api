package zft.control.manager.service.impl;

import zft.control.manager.dao.JedisDataSource;
import zft.control.manager.service.RedisClientTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository("redisClientTemplate")
public class RedisClientTemplateImpl implements RedisClientTemplate {
    private static final Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);

    @Autowired
    private JedisDataSource redisDataSource;

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public String set(String key, String value) {
        String result = null;

        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.get(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    public Long del(String key) {
        Long result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... fields) {
        Long result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hdel(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Boolean result = false;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 查看key所储存的值的类型
     *
     * @param key
     * @return
     */
    @Override
    public String type(String key) {
        String result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.type(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 在某段时间后失效
     *
     * @param key
     * @param seconds
     * @return
     */
    @Override
    public Long expire(String key, int seconds) {
        Long result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.expire(key, seconds);

        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Map<String, String> result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hgetAll(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public String hget(String key, String filed) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hget(key, filed);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public Long hset(String key, String filed, String value) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hset(key, filed, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 移除某个key的生存时间
     *
     * @param key
     * @return
     */
    @Override
    public Long persist(String key) {
        Long result = null;
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.persist(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 往集合里面添加元素
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long sadd(String key, String... value) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sadd(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 删除集合某个元素
     *
     * @param key
     * @return
     */
    @Override
    public Long srem(String key, String... members) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.srem(key, members);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 获取集合所有的元素
     *
     * @param key
     * @return
     */
    @Override
    public Set<String> smembers(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Set<String> result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.smembers(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 判断集合是否有某个值
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Boolean sismember(String key, String value) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Boolean result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sismember(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 应集合的元素的个数
     *
     * @param key
     * @return
     */
    @Override
    public Long scard(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.scard(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 将一个或多个值插入到列表头部
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Long lpush(String key, String... value) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpush(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 移除并获取列表最后一个元素
     *
     * @param key
     * @return
     */
    @Override
    public String rpop(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        String result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpop(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @return
     */
    @Override
    public Long llen(String key) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        Long result = shardedJedis.llen(key);
        redisDataSource.returnResource(shardedJedis);
        return result;
    }

    /**
     * 列表进行修剪
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    @Override
    public String ltrim(String key, int start, int end) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        String result = null;
        try {
            result = shardedJedis.ltrim(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    @Override
    public List<String> lrange(String key, int start, int end) {
        // TODO Auto-generated method stub
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        List<String> result = null;
        try {
            result = shardedJedis.lrange(key, start, end);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 通过索引获取列表中的元素
     *
     * @param key
     * @param index
     * @return
     */
    @Override
    public String lindex(String key, int index) {
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        String result = null;
        try {
            result = shardedJedis.lindex(key, index);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
}