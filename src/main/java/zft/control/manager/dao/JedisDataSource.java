package zft.control.manager.dao;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by sirui on 2016/8/10.
 */
public interface JedisDataSource {
    ShardedJedis getRedisClient();

    void returnResource(ShardedJedis shardedJedis);
}
