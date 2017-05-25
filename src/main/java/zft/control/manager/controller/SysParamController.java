package zft.control.manager.controller;

import zft.control.manager.entity.SysParam;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.SysParamService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("param")
public class SysParamController extends WebController {

    @Autowired
    private SysParamService sysParamService;

    //进入主界面
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        return "param/paramList";
    }

    //进入增加页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) {
        return "param/paramAdd";
    }

    //进入修改页面
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, String key, String value) throws Exception {
        if ((key == null || "".equals(key)) || (value == null || "".equals(value))) {
            model.addAttribute("error", SystemFiles.getCode("000032"));
            return "/error/error";
        }
        SysParam sysParam = sysParamService.get(key);
        model.addAttribute("pm", sysParam);
        return "param/paramEdit";
    }

    //查询列表数据
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String key, String name, String groupName) {
        return sysParamService.findList(offset, limit, key, name, groupName);
    }

    //执行增加操作
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, SysParam param) {
        if (param != null) {
            try {
                sysParamService.add(param);
            } catch (Exception e) {
                e.printStackTrace();
                return Tools.returnWeb("000033");
            }
        } else {
            return Tools.returnWeb("000024");
        }
        return Tools.returnWeb(Constants.SUCCESS);
    }

    //执行修改操作
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(Model model, SysParam param) {
        try {
            sysParamService.edit(param);
        } catch (Exception e) {
            e.printStackTrace();
            return Tools.returnWeb("000033");
        }
        return Tools.returnWeb(Constants.SUCCESS);
    }

    //执行修改操作
    @RequestMapping(value = "/refshCache", method = RequestMethod.POST)
    @ResponseBody
    public String refshCache() throws Exception {
        sysParamService.refshCache();
        return SystemFiles.getCode("000034");
    }

}
