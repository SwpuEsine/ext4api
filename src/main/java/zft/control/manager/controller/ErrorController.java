package zft.control.manager.controller;

import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("error")
public class ErrorController extends WebController {

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String toList(Model model, String errCode) {
        if (StringUtils.isNotNull(errCode)) {
            model.addAttribute("error", SystemFiles.getCode(errCode));
            model.addAttribute("code", errCode);
        }
        return "error/error";
    }
}
