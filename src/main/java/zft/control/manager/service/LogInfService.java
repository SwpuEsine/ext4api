package zft.control.manager.service;

import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;

import java.util.Map;

public interface LogInfService {
    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, String oprUrl, String oprId,
                                              String startDate, String endDate);

    void addSysLog(String url, UserInfo userInf);
}
