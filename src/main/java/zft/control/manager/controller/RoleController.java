package zft.control.manager.controller;

import com.alibaba.fastjson.JSON;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.RoleInfoService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController extends WebController {

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private RedisService redisService;

    //进入主界面
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "role/roleList";
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query() {
        return "role/riskSearch";
    }

    //进入增加页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) throws Exception {
        Map<String, String> map = redisService.hgetAll(Constants.RedisKey.MENU_CACHE);
        List<MenuInfo> menu = new ArrayList<>();
        for (String val : map.values()) {
            menu.add(JSON.parseObject(val, MenuInfo.class));
        }
        model.addAttribute("menuAll", menu);
        return "role/roleAdd";
    }

    //进入修改页面
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, Integer id) throws Exception {
        if (id == null || id == 0) {
            model.addAttribute("error", SystemFiles.getCode("000021"));
            return "/error/error";
        }
        Map<String, String> map = redisService.hgetAll(Constants.RedisKey.MENU_CACHE);
        List<MenuInfo> menu = new ArrayList<>();
        for (String val : map.values()) {
            menu.add(JSON.parseObject(val, MenuInfo.class));
        }
        model.addAttribute("menuAll", menu);
        model.addAttribute("role", roleInfoService.get(id));
        return "role/roleEdit";
    }

    //查询列表数据
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String roleName) {
        return roleInfoService.findLike(offset, limit, roleName);
    }

    //执行增加操作
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, String roleName, String roleMenu) throws Exception {

        if (StringUtils.isNotNull(roleName) && StringUtils.isNotNull(roleMenu)) {
            roleInfoService.add(roleName, roleMenu);
        } else {
            model.addAttribute("error", SystemFiles.getCode("000022"));
            return Tools.returnWeb("000077", "权限名称和权限");
        }
        return Tools.returnWeb(Constants.SUCCESS);
    }

    //执行修改操作
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(Integer roleId, String roleName, String roleMenu) throws Exception {
        roleInfoService.edit(roleId, roleName, roleMenu);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    // 执行删除操作
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase del(Model model, Integer id) throws Exception {
        if (id == null || id == 0)
            return Tools.returnWeb("000021");
        roleInfoService.delete(id);
        return Tools.returnWeb(Constants.SUCCESS);
    }

}
