package zft.control.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zft.control.manager.entity.BrhInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.BrhInfoService;
import zft.control.manager.service.RedisService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;

import java.util.Map;

@Controller
@RequestMapping(value = "/brh")
public class BrhController {

    @Autowired
    private BrhInfoService brhInfoService;

    @Autowired
    private RedisService redisService;

    public static final String BRH_STATUS = "BranchStatus";
    public static final String BRH_TYPE = "BranchType";

    /**
     * 进入主界面
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        // 添加数据字典
        Map<String, String> brhTypeList = redisService.valNameMap(BRH_TYPE);
        model.addAttribute("brhTypeList", brhTypeList);
        Map<String, String> brhStatusList = redisService.valNameMap(BRH_STATUS);
        model.addAttribute("brhStatusList", brhStatusList);
        return "brh/brhList";
    }

    /**
     * 根据条件获取list
     *
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit,
                                                 String brhId, String brhName, String brhType, String brhSta) {

        return brhInfoService.findList(offset, limit, brhId, brhName, brhType, brhSta);
    }

    /**
     * 进入添加页面
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) throws Exception {
        // 添加数据字典
        Map<String, String> brhTypeList = redisService.valNameMap(BRH_TYPE);
        model.addAttribute("brhTypeList", brhTypeList);
        Map<String, String> brhStatusList = redisService.valNameMap(BRH_STATUS);
        model.addAttribute("brhStatusList", brhStatusList);
        return "brh/brhAdd";
    }

    /**
     * 执行添加操作
     *
     * @param model
     * @param brhInfo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, BrhInfo brhInfo) throws Exception {
        if (brhInfo.selfCheck()) {
            brhInfoService.add(brhInfo);
        } else {
            model.addAttribute("error", SystemFiles.getCode("000022"));
            return Tools.returnWeb("000077", "机构编号");
        }
        return Tools.returnWeb(Constants.SUCCESS);
    }

    /**
     * 进入编辑页面
     *
     * @param model
     * @return @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, String id) throws Exception {
        setDetail2Page(model, id);
        return "brh/brhEdit";
    }

    /**
     * 执行更新操作
     *
     * @param brhInfo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(BrhInfo brhInfo) throws Exception {
        if (!brhInfo.selfCheck())
            return Tools.returnWeb("000021");
        brhInfoService.update(brhInfo);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    /**
     * 执行删除操作
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/del")
    @ResponseBody
    public ResponseBase del(String id) throws Exception {
        if (!StringUtils.isNotNull(id))
            return Tools.returnWeb("000021");
        brhInfoService.del(id);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    @RequestMapping(value = "/detail")
    public String view(Model model, String id) throws Exception {
        setDetail2Page(model, id);
        return "brh/brhView";
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBase check(String brhId) throws Exception {
        boolean b = brhInfoService.check(brhId);
        if (b) {
            return Tools.returnWeb(Constants.SUCCESS);
        }
        return Tools.returnWeb("000100", "机构编号");
    }

    private void setDetail2Page(Model model, String id) throws Exception {
        BrhInfo brh = brhInfoService.get(id);
        model.addAttribute("brh", brh);
        // 添加数据字典
        Map<String, String> brhTypeList = redisService.valNameMap(BRH_TYPE);
        model.addAttribute("brhTypeList", brhTypeList);
        Map<String, String> brhStatusList = redisService.valNameMap(BRH_STATUS);
        model.addAttribute("brhStatusList", brhStatusList);
    }
}
