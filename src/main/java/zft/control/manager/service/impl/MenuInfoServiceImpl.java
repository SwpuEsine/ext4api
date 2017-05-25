package zft.control.manager.service.impl;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zft.control.manager.service.RedisService;
import zft.control.manager.tools.Constants;
import zft.control.manager.tools.Tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuInfoService")
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfDao menuInfDao;
    @Autowired
    private RedisService redisService;

    @Override
    public List<MenuInfo> findAll() throws Exception {
        return menuInfDao.findAll();
    }

    @Override
    public GridListRes<Map<String, Object>> findLike(Integer offset, Integer limit, String menuName, String menuUrl, String suName) {
        Map<String, String> map = new HashMap<>();
        map.put("menuName", menuName);
        map.put("menuUrl", menuUrl);
        map.put("suName", suName);
        return menuInfDao.findList(offset, limit, map);
    }

    @Override
    public MenuInfo get(Integer menuId) throws Exception {
        return menuInfDao.get(menuId);
    }

    @Override
    public void edit(MenuInfo menuInfo) throws Exception {
        MenuInfo edit = get(menuInfo.getMenuId());
        BeanUtils.copyProperties(menuInfo, edit, Tools.getNullPropertyNames(menuInfo));
        menuInfDao.update(edit);
        redisService.hset(Constants.RedisKey.MENU_CACHE, menuInfo.getMenuId() + "", JSON.toJSONString(menuInfo));
    }

    @Override
    public void add(MenuInfo menuInfo) throws Exception {
        menuInfDao.save(menuInfo);
        redisService.hset(Constants.RedisKey.MENU_CACHE, menuInfo.getMenuId() + "", JSON.toJSONString(menuInfo));
    }

    @Override
    public List<String[]> getSuperId() {
        List<String[]> list = menuInfDao.getSuperId();
        return list;
    }

    @Override
    public void delete(Integer id) throws Exception {
        menuInfDao.delete(id);
        redisService.hdel(Constants.RedisKey.MENU_CACHE, id + "");
    }
}
