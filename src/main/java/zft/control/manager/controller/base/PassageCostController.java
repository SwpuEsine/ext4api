package zft.control.manager.controller.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zft.control.manager.entity.PassageCostInfo;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.PassageCostService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.Tools;

@Controller
@RequestMapping("passageCost")
public class PassageCostController {
	 	@Autowired
	    private PassageCostService passageCostService;

	    /**
	     * 进入主界面
	     *
	     * @return
	     */
	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String toList() {
	        return "base/passgeCostList";
	    }

	    /**
	     * 根据条件获取list
	     * @param offset
	     * @param limit
	     * @return
	     */
	    @RequestMapping(value = "/list", method= RequestMethod.POST)
	    @ResponseBody
	    public GridListRes<Map<String, Object>> list(Integer offset, Integer limit,
	                                                 PassageCostInfo pci) {
	    	Map m=new HashMap();
	    	m.put("disc_Cd", pci.getDiscCd());
	    	m.put("inst_Code", pci.getInstCode());
	    	m.put("fri_In", pci.getFriIn());
	    	m.put("mcc", pci.getMcc());
	        return passageCostService.findList(offset, limit, m);
	    }

	    /**
	     * 进入添加页面
	     *
	     * @return
	     */
	    @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String toAdd(Model model) throws Exception {
	        List<PassageCostInfo> pci = passageCostService.findAll();
	        model.addAttribute("pci", pci);
	        return "base/psgCostAdd";
	    }

	    /**
	     * 执行添加操作
	     * @param model
	     * @param brhInfo
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    @ResponseBody
	    public ResponseBase add(Model model, PassageCostInfo pci,HttpSession session) throws Exception {			    	
			pci.setUpdOpr(((UserInfo)session.getAttribute(Constants.SESSION_USER)).getUserId());
			pci.setCrtOpr(((UserInfo)session.getAttribute(Constants.SESSION_USER)).getUserId());
			pci.setCrtTs(Tools.getDateTime());;   // 创建时间
			pci.setUpdTs(Tools.getDateTime()) ; 
	    	passageCostService.add(pci);
	    	return Tools.returnWeb(Constants.SUCCESS);
	    }

	    /**
	     * 进入编辑页面
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/edit", method = RequestMethod.GET)
	    public String toEdit(Model model) throws Exception {
//	        List<PassageCostInfo pci> brhInfoList = brhInfoService.findAll();
//	        model.addAttribute("brhInfoList", brhInfoList);
	        return "brh/brhEdit";
	    }

	    /**
	     * 执行更新操作
	     * @param brhInfo
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	    public ResponseBase edit(PassageCostInfo pci) throws Exception {
//	        if (!StringUtils.isNotNull(brhInfo.getBrhId()) || !StringUtils.isNotNull(brhInfo.getBrhName()))
//	            return Tools.returnWeb("000021");
//	        brhInfoService.update(brhInfo);
	        return Tools.returnWeb(Constants.SUCCESS);
	    }

	    /**
	     * 执行删除操作
	     * @param brhId
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/del")
	    @ResponseBody
	    public ResponseBase del(String brhId) throws Exception {
//	        if (!StringUtils.isNotNull(brhId))
//	            return Tools.returnWeb("000021");
//	        brhInfoService.del(brhId);
	        return Tools.returnWeb(Constants.SUCCESS);
	    }
}
