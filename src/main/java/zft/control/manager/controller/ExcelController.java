package zft.control.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import zft.control.manager.report.TestExcel;

import java.util.HashMap;

@Controller
@RequestMapping("excel")
public class ExcelController extends WebController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView monthAnalysis(ModelMap model) {
        TestExcel excel = new TestExcel();
        model.put("params", new HashMap<>());
        return new ModelAndView(excel, model);
    }
}
