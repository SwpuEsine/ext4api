package zft.control.manager.service;

import java.util.List;

public interface QueueService {
    /**
     * 插入队列最上层位置
     *
     * @param key   插入的队列key
     * @param value 插入的值
     * @return
     */
    Long pushTop(String key, String... value);

    /**
     * 弹出队列最后的一个值
     *
     * @param key 队列key
     * @return
     */
    String popLast(String key);

    /**
     * 获取队列最上层一个值
     *
     * @param key
     * @return
     */
    String getTop(String key);

    /**
     * 设置队列大小
     *
     * @param key
     */
    void trim(String key);

    /**
     * 截取队列指定位置的值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    List<String> lrange(String key, int start, int end);

    /**
     * 删除队列
     *
     * @param key
     */
    void del(String key);

}
