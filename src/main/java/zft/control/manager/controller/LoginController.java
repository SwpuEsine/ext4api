package zft.control.manager.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.RoleInfoService;
import zft.control.manager.service.UserLoginService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.Tools;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("web")
public class LoginController extends WebController {

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession httpSession, Model model) throws Exception {
        UserInfo userInf = (UserInfo) httpSession.getAttribute(Constants.SESSION_USER);
        List<String> urlAll = (List<String>) httpSession.getAttribute(Constants.SESSION_MENU);
        if (userInf != null && urlAll != null) {
            model.addAttribute("roleInf", roleInfoService.get(userInf.getRoleId()));
            Map<String, String> map = redisService.hgetAll(Constants.RedisKey.MENU_CACHE);
            List<MenuInfo> menu = new ArrayList<>();
            MenuInfo m;
            for (String val : map.values()) {
                m = JSON.parseObject(val, MenuInfo.class);
                String urlLevel = m.getUrlLevel();
                if (urlLevel != null && ("1".equals(urlLevel) || "2".equals(urlLevel))) {
                    menu.add(m);
                }
            }
            model.addAttribute("menuAll", menu);
            return "main";
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase login(String uId, String userPwd, String verify, String rand, HttpSession httpSession) throws Exception {
        String rand1 = httpSession.getAttribute("rand").toString();
        rand = rand.toUpperCase();
        rand1 = rand1.toUpperCase();
        if (!StringUtils.isNotNull(uId)) {
            return Tools.returnWeb("000022");
        }
        if (!StringUtils.isNotNull(userPwd)) {
            return Tools.returnWeb("000022");
        }
        if (rand == null || !rand.equals(rand1)) {
            httpSession.setAttribute("rand", "");
            return Tools.returnWeb("000029");
        }

        String checkStr = userLoginService.checkUser(uId, userPwd, verify);
        if (checkStr != null) {
            return Tools.returnWeb("000080", checkStr);
        } else {
            UserInfo userInf = userLoginService.getUserInfo(uId);
            httpSession.setAttribute(Constants.SESSION_USER, userInf);
            httpSession.setAttribute(Constants.SESSION_MENU, userLoginService.getUserMenu(userInf.getRoleId()));
            redisService.set(Tools.getWebLoginId(uId), httpSession.getId());
            redisService.expire(Tools.getWebLoginId(uId), 30 * 60);
            return Tools.returnWeb(Constants.SUCCESS);
        }
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String login(HttpSession httpSession) {
        UserInfo userInf = (UserInfo) httpSession.getAttribute(Constants.SESSION_USER);
        if (userInf != null) {
            String key = Tools.getWebLoginId(userInf.getUserId());
            String val = redisService.get(key);
            if (val != null && val.equals(httpSession.getId()))
                redisService.del(key);
        }
        httpSession.removeAttribute(Constants.SESSION_USER);
        httpSession.removeAttribute(Constants.SESSION_MENU);
        return "redirect:/";
    }


}
