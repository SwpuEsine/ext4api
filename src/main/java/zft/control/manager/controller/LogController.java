package zft.control.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.LogInfService;

import java.util.Map;

/**
 * 系统日志
 */
@Controller
@RequestMapping("log")
public class LogController extends WebController {

    @Autowired
    private LogInfService logInfService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        return "log/logList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String oprUrl, String oprId,
                                                 String startDate, String endDate) {
        return logInfService.findList(offset, limit, oprUrl, oprId, startDate, endDate);
    }
}
