package zft.control.manager.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.entity.SettleInsInf;
import zft.control.manager.entity.UserInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.service.RedisService;
import zft.control.manager.service.SettleInsInfService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.SystemFiles;
import zft.control.manager.tools.Tools;

/**
 * 清算通道管理页面控制器
 * 
 * @author qianpyn
 *
 */
@Controller
@RequestMapping("/settleIns")
public class SettleInsController extends WebController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private SettleInsInfService settleInsInfService;

	/**
	 * 进入页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String toList(Model model) {
	
		model.addAttribute("routeStatus",
				redisService.valNameMap("RouteStatus"));
		return "settleIns/settleInsList";
	}

	/**
	 * 页面数据显示
	 * 
	 * @param offset
	 * @param limit
	 * @param stlmID
	 * @param descr
	 * @param useFlag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public GridListRes<Map<String, Object>> list(Integer offset, Integer limit,
			String stlmID, String descr, String useFlag) throws Exception {

		return settleInsInfService.findList(offset, limit, stlmID, descr,
				useFlag);
	}

	/**
	 * 进入添加页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(Model model) {
		model.addAttribute("routeStatus",
				redisService.valNameMap("RouteStatus"));
		return "settleIns/settleInsAdd";
	}

	/**
	 * 执行添加操作
	 * 
	 * @param model
	 * @param session
	 * @param settleInsInf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBase add(Model model, HttpSession session,
			SettleInsInf settleInsInf) throws Exception {

		if (!StringUtils.isNotNull(settleInsInf.getStlmId()) || !StringUtils.isNotNull(settleInsInf.getDescr())
				|| !StringUtils.isNotNull(settleInsInf.getUseFlag())) {
			model.addAttribute("error", SystemFiles.getCode("000022"));
			return Tools.returnWeb("000077", "通道信息");
		}
		//验证重复
		if(settleInsInf.getStlmId().equals(settleInsInfService.get(settleInsInf.getStlmId()).getStlmId())){
			return Tools.returnWeb("000080", "通道编号已经存在");
		}
		UserInfo userInfo = (UserInfo) session
				.getAttribute(Constants.SESSION_USER);
		settleInsInf.setUpdUserId(userInfo.getUserId());

		settleInsInfService.save(settleInsInf);

		return Tools.returnWeb(Constants.SUCCESS);
	}

	/**
	 * 进入修改页面
	 * 
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Model model, String id) throws Exception {
		SettleInsInf settleInsInf = settleInsInfService.get(id);
		model.addAttribute("settleInsInf", settleInsInf);
		model.addAttribute("routeStatus",
				redisService.valNameMap("RouteStatus"));
		return "settleIns/settleInsEdit";
	}

	/**
	 * 修改操作
	 * 
	 * @param model
	 * @param session
	 * @param settleInsInf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBase edit(Model model, HttpSession session,
			SettleInsInf settleInsInf) throws Exception {
		if (!StringUtils.isNotNull(settleInsInf.getStlmId()) || !StringUtils.isNotNull(settleInsInf.getDescr())
				|| !StringUtils.isNotNull(settleInsInf.getUseFlag())) {
			model.addAttribute("error", SystemFiles.getCode("000022"));
			return Tools.returnWeb("000077", "通道信息");
		}
		
		UserInfo userInfo = (UserInfo) session
				.getAttribute(Constants.SESSION_USER);
		settleInsInf.setUpdUserId(userInfo.getUserId());
		settleInsInfService.update(settleInsInf);
		return Tools.returnWeb(Constants.SUCCESS);
	}

	/**
	 * 删除操作
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public ResponseBase del(String id) throws Exception {
		if (!StringUtils.isNotNull(id)) {
			return Tools.returnWeb("000021");
		}

		settleInsInfService.delete(id);
		return Tools.returnWeb(Constants.SUCCESS);
	}
}
