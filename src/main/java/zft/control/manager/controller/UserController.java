package zft.control.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.objs.view.SelectArray;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.RoleInfoService;
import zft.control.manager.service.SelectService;
import zft.control.manager.service.UserInfService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends WebController {

    @Autowired
    private UserInfService userInfService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SelectService selectService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toList(Model model) {
        Map<String, String> userStatus = redisService.valNameMap("UserStatus");
        Map<String, String> userType = redisService.valNameMap("UserType");
        model.addAttribute("userStatus", userStatus);
        model.addAttribute("userType", userType);
        return "user/userList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(Model model) throws Exception {
        List<RoleInf> role = roleInfoService.findAll();
        Map<String, String> userStatus = redisService.valNameMap("UserStatus");
        model.addAttribute("userStatus", userStatus);
        model.addAttribute("role", role);
        return "user/userAdd";
    }

    // 进入修改页面
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, String id) throws Exception {
        if (!StringUtils.isNotNull(id)) {
            model.addAttribute("error", SystemFiles.getCode("000021"));
            return "/error/error";
        }
        List<RoleInf> role = roleInfoService.findAll();
        UserInfo userInf = userInfService.get(id);
        model.addAttribute("role", role);
        model.addAttribute("userStatus", redisService.valNameMap("UserStatus"));
        model.addAttribute("user", userInf);
        return "user/userEdit";
    }

    // 查询列表数据
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit, String name, String userId, String userStatus) {
        return userInfService.findList(offset, limit, name, userId, userStatus);
    }

    // 执行增加操作
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase add(Model model, UserInfo userInf, String passwd2) throws Exception {
        if (!userInf.getPasswd().equals(passwd2)) {
            return Tools.returnWeb("000023");
        }
        if (!userInfService.check(userInf.getUserId())) {
            return Tools.returnWeb("000008");
        }
        userInfService.add(userInf);

        return Tools.returnWeb(Constants.SUCCESS);
    }

    // 执行修改操作
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase edit(Model model, UserInfo userInf) throws Exception {
        userInfService.edit(userInf);
        return Tools.returnWeb(Constants.SUCCESS);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase reset(String userId, String userPwd) throws Exception {
        if (!StringUtils.isNotNull(userId)) {
            return Tools.returnWeb("000021");
        }
        if (!StringUtils.isNotNull(userPwd)) {
            return Tools.returnWeb("000021");
        }
        return userInfService.reset(userId, userPwd);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public ResponseBase check(String userId) throws Exception {
        boolean b = userInfService.check(userId);
        if (b == true) {
            return Tools.returnWeb(Constants.SUCCESS);
        } else {
            return Tools.returnWeb("000008");
        }
    }

    @RequestMapping(value = "/updPwdView", method = RequestMethod.GET)
    public String updPwdView(HttpSession httpSession) throws Exception {
        return "user/userPwd";
    }

    @ResponseBody
    @RequestMapping(value = "updPwd", method = RequestMethod.GET)
    public ResponseBase updPwd(String oldPassword, String newPassword, HttpSession httpSession) throws Exception {
        UserInfo userInf = (UserInfo) httpSession.getAttribute(Constants.SESSION_USER);
        if (oldPassword.equals(userInf.getPasswd())) {
            userInf.setPasswd(newPassword);
            userInfService.edit(userInf);
            return Tools.returnWeb(Constants.SUCCESS);
        } else {
            Tools.returnWeb("000038");
        }
        return null;
    }

    @RequestMapping(value = "/userSel", method = RequestMethod.GET)
    @ResponseBody
    public SelectArray userSel(Integer page, String id, String text) {
        if (page == null) {
            page = 0;
        }
        return selectService.userSelect(page, id, text);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase del(Model model, String id) throws Exception {
        if (!StringUtils.isNotNull(id))
            return Tools.returnWeb("000021");
        userInfService.delete(id);
        return Tools.returnWeb(Constants.SUCCESS);
    }
}
