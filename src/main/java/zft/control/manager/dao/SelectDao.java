package zft.control.manager.dao;

import zft.control.manager.objs.view.SelectArray;

public interface SelectDao {

    SelectArray getSelect(String tableName, String[] columns, Integer page, String id, String text);
}