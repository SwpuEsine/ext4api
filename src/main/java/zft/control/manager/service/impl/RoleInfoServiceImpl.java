package zft.control.manager.service.impl;


import zft.control.manager.dao.MenuInfDao;
import zft.control.manager.dao.RoleInfDao;
import zft.control.manager.entity.MenuInfo;
import zft.control.manager.entity.RoleInf;
import zft.control.manager.objs.view.GridListRes;
import zft.control.manager.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfDao roleInfDao;

    @Autowired
    private MenuInfDao menuInfDao;


    @Override
    public List<RoleInf> findAll() throws Exception {
        return roleInfDao.findAll();
    }

    @Override
    public GridListRes<Map<String, Object>> findLike(Integer offset, Integer limit, String roleName) {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("roleName", roleName);
        return roleInfDao.findList(offset, limit, parmas);
    }

    @Override
    public RoleInf get(Integer id) throws Exception {
        return roleInfDao.get(id);
    }

    @Override
    public void edit(Integer roleId, String roleName, String roleMenu) throws Exception {
        RoleInf edit = get(roleId);
        edit.setRoleName(roleName);
        edit.setRoleMenu(roleMenu);
        roleInfDao.saveOrUpdate(edit);
    }

    @Override
    public void add(String roleName, String roleMenu) throws Exception {
        RoleInf roleInf = new RoleInf();
        roleInf.setRoleName(roleName);
        roleInf.setRoleMenu(roleMenu);
        roleInfDao.save(roleInf);
    }

    @Override
    public void delete(Integer menuId) throws Exception {
        roleInfDao.delete(menuId);
    }

    @Override
    public List<MenuInfo> getMenuAll() throws Exception {
        List<MenuInfo> list = menuInfDao.findAll();
        return list;
    }
}
