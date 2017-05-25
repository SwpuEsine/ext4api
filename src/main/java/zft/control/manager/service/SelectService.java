package zft.control.manager.service;

import zft.control.manager.objs.view.SelectArray;

public interface SelectService {

    SelectArray userSelect(Integer page, String o, String text);
}
