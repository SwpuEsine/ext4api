package zft.control.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.service.QueueService;
import zft.control.manager.service.RedisClientTemplate;

import java.util.List;

@Service("queueService")
public class QueueServiceImpl implements QueueService {
    private static Integer maxLLen = 100;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Override
    public Long pushTop(String key, String... value) {
        long s = redisClientTemplate.lpush(key, value);
        redisClientTemplate.expire(key, 60 * 10);
        return s;
    }

    @Override
    public String popLast(String key) {
        return redisClientTemplate.rpop(key);
    }

    @Override
    public String getTop(String key) {
        return redisClientTemplate.lindex(key, 0);
    }

    @Override
    public void trim(String key) {
        Long len = redisClientTemplate.llen(key);

        if (len > maxLLen) {
            redisClientTemplate.ltrim(key, 0, maxLLen);
        }
    }

    public List<String> lrange(String key, int start, int end) {
        return redisClientTemplate.lrange(key, start, end);
    }

    @Override
    public void del(String key) {
        redisClientTemplate.del(key);
    }
}