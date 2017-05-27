package zft.control.manager.service;

import java.util.List;
import java.util.Map;

import zft.control.manager.entity.RouteSettleCtl;
import zft.control.manager.entity.SettleInsInf;
import zft.control.manager.objs.view.GridListRes;
/**
 * 通道管理業務邏輯層接口
 * @author qianpyn
 *
 */
public interface SettleInsInfService {
	
	SettleInsInf get(String stlmID) throws Exception;

    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit,
    	String stlmID, String descr, String useFlag) throws Exception;

    void save(SettleInsInf entity) throws Exception;

    void update(SettleInsInf entity) throws Exception;

    void delete(String id) throws Exception;

}
