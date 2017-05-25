package zft.control.manager.report;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import zft.control.manager.dao.UserInfDao;
import zft.control.manager.tools.ApplicationContextHelper;
import zft.control.manager.tools.poi.ExcelUtils;

import java.util.List;
import java.util.Map;

public class TestExcel extends EasyExcel {

    @Autowired
    private UserInfDao userInfDao = (UserInfDao) ApplicationContextHelper.getBean("userInfDao");

    /**
     * 表头
     *
     * @return
     */
    @Override
    public String setName() {
        return "用户信息报表";
    }

    /**
     * 显示表列名称
     *
     * @return
     */
    @Override
    public String[] setTitle() {
        return new String[]{"用户角色", "用户账号", "姓名", "手机号", "邮箱", "创建时间", "更新时间", "用户状态"};
    }

    /**
     * 查询数据LIST<Map>对象Key值
     *
     * @return
     */
    @Override
    public String[] setKey() {
        return new String[]{"ROLE_ID", "USER_ID", "NAME", "TEL", "EMAIL", "CRT_TS", "UPD_TS", "USER_STATUS"};
    }

    /**
     * title 样式
     *
     * @param workbook
     * @return
     */
    @Override
    public HSSFCellStyle setTitleStyle(HSSFWorkbook workbook) {
        return ExcelUtils.styleCell(workbook, 12, true, true);
    }

    /**
     * 数据样式
     *
     * @param workbook
     * @return
     */
    @Override
    public HSSFCellStyle setColumnStyle(HSSFWorkbook workbook) {
        return ExcelUtils.styleCell(workbook, 12, false, true);
    }

    /**
     * 要统计合的列，"key1,key2,key3"
     *
     * @return
     */
    @Override
    public String sumColumn() {
        return null;
    }

    /**
     * 表格设置
     *
     * @param sheet
     */
    @Override
    public void settings(HSSFSheet sheet) {
        sheet.setDefaultColumnWidth(15);
    }

    /**
     * 数据库业务查询
     *
     * @param offset
     * @return
     */
    @Override
    public List<Map<String, Object>> data(Integer offset) {
        return null;//userInfDao.findExcel(offset, dataMax, params);
    }

}