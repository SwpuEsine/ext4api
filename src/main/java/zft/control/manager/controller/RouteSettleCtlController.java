package zft.control.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.RouteSettleCtlService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by work on 2017/5/24.
 */
@Controller
@RequestMapping("/routeSettleCtl")
public class RouteSettleCtlController extends WebController {

    @Autowired
    private RouteSettleCtlService routeSettleCtlService;

    @Autowired
    private RedisService redisService;

    private static final String ROUTE_STATUS = "RouteStatus";
    /**
     * 列表页面
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        model.addAttribute("routeStatus", redisService.valNameMap(ROUTE_STATUS));
        return "routeSettleCtl/routeSettleCtlList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String id,
                                                 String routeName, String routeCtlId,
                                                 String routeCtlSta) throws Exception {

        return routeSettleCtlService.findList(offset, limit, id, routeName, routeCtlId, routeCtlSta);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) {
        model.addAttribute("routeStatus", redisService.valNameMap(ROUTE_STATUS));
        return "routeSettleCtl/routeSettleCtlAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, HttpSession session, RouteSettleCtl routeSettleCtl)
            throws Exception {

        if (!StringUtils.isNotNull(routeSettleCtl.getId())) {
            model.addAttribute("error", SystemFiles.getCode("000022"));
            return Tools.returnWeb("000077", "通道编号");
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER);
        routeSettleCtl.setUpdUsrId(userInfo.getUserId());
        routeSettleCtl.setLastOperIn("1");
        routeSettleCtlService.save(routeSettleCtl);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, String id) throws Exception {
        RouteSettleCtl routeSettleCtl = routeSettleCtlService.get(id);
        model.addAttribute("routeSettleCtl", routeSettleCtl);
        // 添加数据字典
        model.addAttribute("routeStatus", redisService.valNameMap(ROUTE_STATUS));
        return "routeSettleCtl/routeSettleCtlEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(Model model, HttpSession session, RouteSettleCtl routeSettleCtl) throws Exception {
        if (!StringUtils.isNotNull(routeSettleCtl.getId())) {
            model.addAttribute("error", SystemFiles.getCode("000022"));
            return Tools.returnWeb("000077", "通道编号");
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER);
        routeSettleCtl.setUpdUsrId(userInfo.getUserId());
        routeSettleCtlService.update(routeSettleCtl);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public ResponseBase del(String id) throws Exception {
        if (!StringUtils.isNotNull(id))
            return Tools.returnWeb("000021");
        routeSettleCtlService.delete(id);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    @RequestMapping(value = "/detail")
    public String view(Model model, String id) throws Exception {
        RouteSettleCtl routeSettleCtl = routeSettleCtlService.get(id);
        model.addAttribute("routeSettleCtl", routeSettleCtl);
        // 添加数据字典
        return "routeSettleCtl/routeSettleCtlView";
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBase check(String id) throws Exception {
        if(routeSettleCtlService.check(id)) {
            return Tools.returnWeb(Constants.SUCCESS);
        }
        return Tools.returnWeb("000100", "通道编号");
    }
}