package zft.control.manager.controller.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zft.control.manager.entity.BrhInfo;
import zft.control.manager.entity.PassageMsgInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.PassageMsgService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.Tools;

@Controller
@RequestMapping("passageMsg")
public class PassageMsgController {
	 	@Autowired
	    private PassageMsgService passageMsglService;

	    /**
	     * 进入主界面
	     *
	     * @return
	     */
	    @RequestMapping(value = "/list", method = RequestMethod.GET)
	    public String toList() {
	    	System.out.println("???????");
	        return "base/passageMsgList";
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
	    		PassageMsgInfo pmi) {
	    	Map<String, String> m=new HashMap<String,String>();
	    	System.out.println(">>>>>>>>>>"+pmi.getOverrunFlag());
	    	m.put("inst_Code",pmi.getInstCode());
	    	m.put("inst_Name", pmi.getInstName());
	    	m.put("inst_Stat", pmi.getInstStat());
	    	m.put("OVERRUN_FLAG", pmi.getOverrunFlag());
	        return passageMsglService.findList(offset, limit, m);
	    }

	    /**
	     * 进入添加页面
	     *
	     * @return
	     */
	    @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String toAdd(Model model) throws Exception {
	    	return "base/passageMsgAdd";
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
	    public ResponseBase add(Model model, BrhInfo brhInfo) throws Exception {
			return null;
//	        if (StringUtils.isNotNull(brhInfo.getBrhName())) {
//	            brhInfoService.add(brhInfo);
//	        } else {
//	            model.addAttribute("error", SystemFiles.getCode("000022"));
//	            Tools.returnWeb("000077", "机构名称");
//	        }
//	        return Tools.returnWeb(Constants.SUCCESS);
	    }

	    /**
	     * 进入编辑页面
	     * @param model
	     * @return
	     * @throws Exception
	     */
	    @RequestMapping(value = "/edit", method = RequestMethod.GET)
	    public String toEdit(Model model) throws Exception {
//	        List<BrhInfo> brhInfoList = brhInfoService.findAll();
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
	    public ResponseBase edit(BrhInfo brhInfo) throws Exception {
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

