package zft.control.manager.controller;

import zft.control.manager.entity.MenuInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.MenuInfoService;
import zft.control.manager.service.RedisService;
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

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("menu")
public class MenuController extends WebController {

    @Autowired
    private MenuInfoService menuInfoService;
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/toMain", method = RequestMethod.GET)
    public String toMain() {
        return "main";
    }

    //进入主界面
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        return "menu/menuList";
    }

    //进入增加页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) {
        List<String[]> list = menuInfoService.getSuperId();
        list.add(0, new String[]{"", "无"});
        model.addAttribute("superIds", list);
        model.addAttribute("urlLevel", redisService.valNameMap("UrlLevel"));
        return "menu/menuAdd";
    }

    //进入修改页面
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, Integer id) throws Exception {
        if (id == null || id == 0) {
            model.addAttribute("error", SystemFiles.getCode("000021"));
            return "/error/error";
        }
        List<String[]> list = menuInfoService.getSuperId();
        list.add(0, new String[]{"", "无"});
        model.addAttribute("superIds", list);
        model.addAttribute("menu", menuInfoService.get(id));
        model.addAttribute("urlLevel", redisService.valNameMap("UrlLevel"));
        return "menu/menuEdit";
    }

    //查询列表数据
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String menuName, String menuUrl, String suName) {
        return menuInfoService.findLike(offset, limit, menuName, menuUrl, suName);
    }

    //执行增加操作
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, MenuInfo menuInfo) throws Exception {
        menuInfoService.add(menuInfo);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    //执行增加操作
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase del(Model model, Integer id) throws Exception {
        if (id == null || id == 0) {
            return Tools.returnWeb("000021");
        }
        menuInfoService.delete(id);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    //执行修改操作
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(MenuInfo menuInfo) throws Exception {
        menuInfoService.edit(menuInfo);
        return Tools.returnWeb(Constants.SUCCESS);
    }

}
