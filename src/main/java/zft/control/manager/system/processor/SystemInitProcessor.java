package zft.control.manager.system.processor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zft.control.manager.net.tcp.server.TcpServer;
import zft.control.manager.service.RedisService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 初始化加载系统参数
 */
@Component
public class SystemInitProcessor {
    private static final Logger LOGGER = Logger.getLogger(SystemInitProcessor.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private TcpServer tcpServer;

    @PostConstruct
    public void init() {
        try {
            redisService.initAll();
            new Thread(tcpServer).start();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug("redis初始化失败!!!!!!!");
        }
    }

    @PreDestroy
    public void destroy() {
        try {
            tcpServer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
