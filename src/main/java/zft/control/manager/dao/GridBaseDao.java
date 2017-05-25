package zft.control.manager.dao;

import zft.control.manager.objs.view.GridListRes;

import java.util.Map;

interface GridBaseDao {
    GridListRes<Map<String, Object>> findList(Integer offset, Integer limit, Map<String, String> params);
}
