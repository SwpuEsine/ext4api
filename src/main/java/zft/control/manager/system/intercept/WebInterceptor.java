package zft.control.manager.system.intercept;

import com.alibaba.fastjson.JSONObject;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.service.LogInfService;
import zft.control.manager.service.RedisService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.Tools;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WebInterceptor extends HandlerInterceptorAdapter {
    private List<String> uncheckUrls;
    private static final Logger LOGGER = Logger.getLogger(WebInterceptor.class);

    @Autowired
    public RedisService redisService;
    @Autowired
    public LogInfService logInfService;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            LOGGER.error(handler);
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3) throws Exception {

    }

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
                             Object arg2) throws Exception {

        String requestUrl = req.getRequestURI();
        String menuUrl;
        if (requestUrl.indexOf(";") == -1) {
            menuUrl = requestUrl.substring(requestUrl.lastIndexOf("/"));
        } else {
            menuUrl = requestUrl.substring(requestUrl.lastIndexOf("/"), requestUrl.indexOf(";"));
        }

        //登录接口不认证或APP请求接口
        if (uncheckUrls.indexOf(menuUrl) != -1) {
            return true;
        }

        UserInfo userInf = (UserInfo) req.getSession().getAttribute(Constants.SESSION_USER);
        List<String> urlAll = (List<String>) req.getSession().getAttribute(Constants.SESSION_MENU);
        if (userInf != null && urlAll != null) {
            String sessionId = redisService.get(Tools.getWebLoginId(userInf.getUserId()));
            if ((sessionId == null || "".equals(sessionId)) || !sessionId.equals(req.getSession().getId())) {
                resultError(res, "000003");
                return false;
            }

            redisService.expire(Tools.getWebLoginId(userInf.getUserId()), 30 * 60);
            if ("GET".equals(req.getMethod().toUpperCase())) {
                return true;
            }

            String url = requestUrl.substring(requestUrl.indexOf("/", 1));
            if (urlAll.lastIndexOf(url) != -1) {
                if (url.endsWith("/edit") || url.endsWith("/add")) {
                    logInfService.addSysLog(url, userInf);
                }
                return true;
            }

            resultError(res, "000028");
        } else {
            resultError(res, "000003");
        }
        return false;
    }

    private void resultError(HttpServletResponse res, String errCode) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = res.getWriter();
        printWriter.println(JSONObject.toJSONString(Tools.returnWeb(errCode)));
        printWriter.flush();
        printWriter.close();
    }

    public List<String> getUncheckUrls() {
        return uncheckUrls;
    }

    public void setUncheckUrls(List<String> uncheckUrls) {
        this.uncheckUrls = uncheckUrls;
    }


}