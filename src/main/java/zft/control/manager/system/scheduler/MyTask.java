package zft.control.manager.system.scheduler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    protected static final Logger LOGGER = Logger.getLogger(MyTask.class);

//    @Scheduled(cron = "0/60 * *  * * ? ")   //每5秒执行一次
//    public void test() {
//        System.out.println("11111111111111111111111111111");
//    }
}