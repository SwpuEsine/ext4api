package zft.control.manager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.dao.LogInfDao;
import zft.control.manager.dao.UserInfDao;
import zft.control.manager.entity.SysLogInf;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.LogInfService;
import zft.control.manager.system.intercept.WebInterceptor;
import zft.control.manager.tools.Tools;

import java.util.HashMap;
import java.util.Map;

@Service("logInfService")
public class LogInfServiceImpl implements LogInfService {
    private static final Logger LOGGER = Logger.getLogger(LogInfServiceImpl.class);
    @Autowired
    private LogInfDao logInfDao;

    @Override
    public GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String oprUrl, String oprId,
                                                     String startDate, String endDate) {
        Map<String, String> params = new HashMap<>();
        params.put("oprUrl", oprUrl);
        params.put("oprId", oprId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return logInfDao.findList(offset, limit, params);
    }

    @Override
    public void addSysLog(String url, UserInfo userInf) {
        SysLogInf logInf = new SysLogInf();
        logInf.setOprId(userInf.getUserId());
        logInf.setOprUrl(url);
        logInf.setOprTs(Tools.getDateTime());
        try {
            logInfDao.save(logInf);
        } catch (Exception e) {
            LOGGER.error("记录系统日志出错误！");
        }
    }

}
