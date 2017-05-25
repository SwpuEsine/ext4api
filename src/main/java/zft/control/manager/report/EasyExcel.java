package zft.control.manager.report;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import zft.control.manager.tools.StringUtils;
import zft.control.manager.tools.poi.ExcelUtils;
import zft.control.manager.tools.poi.MyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EasyExcel extends AbstractExcelView {
    protected static final Logger LOGGER = Logger.getLogger(EasyExcel.class);
    private int dataStart = 0;
    protected int dataMax = 1000;
    protected Map<String, String> params;

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = workbook.createSheet(setName());
        params = (Map<String, String>) model.get("params");
        settings(sheet);

        HSSFCell cell;

        int n = 0;
        int column = 0;
        for (String title : setTitle()) {
            cell = getCell(sheet, 0, n++);
            cell.setCellStyle(setTitleStyle(workbook));
            setText(cell, title);
        }
        column++;
        List<Map<String, Object>> data;
        Map<Integer, BigDecimal> sumMap = new HashMap<>();
        int offset = 0;
        HSSFCellStyle style = setColumnStyle(workbook);
        data = data(offset);
        while (data.size() == dataMax) {
            for (Map<String, Object> entity : data) {
                HSSFRow sheetRow = sheet.createRow(column + dataStart);
                int v = 0;
                for (String key : setKey()) {
                    cell = sheetRow.createCell(v++);
                    cell.setCellStyle(style);
                    String val = StringUtils.oTs(entity.get(key));
                    cell.setCellValue(val);
                    if (sumColumn() != null) {
                        try {
                            if (sumColumn().indexOf(key) != -1 && StringUtils.isNotNull(val)) {
                                BigDecimal oldVal = sumMap.get(v);
                                if (oldVal != null) {
                                    sumMap.put(v, new BigDecimal(val).add(oldVal));
                                } else {
                                    sumMap.put(v, new BigDecimal(val));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            LOGGER.error("报表统计列数据类型不正确！");
                        }
                    }
                }
                column++;
            }
            offset += data.size();
            data.clear();
            if (column >= 60000) {
                break;
            }
            data = data(offset);
        }

        if (sumMap.size() != 0) {
            HSSFRow sheetRow = sheet.createRow(column + dataStart);
            cell = sheetRow.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue("合计：");

            for (Integer key : sumMap.keySet()) {
                cell = sheetRow.createCell(key - 1);
                cell.setCellStyle(style);
                ExcelUtils.styleCell(workbook, 12, true, true);
                String val = StringUtils.oTs(sumMap.get(key));
                cell.setCellValue(val);
            }
        }
        //设置下载时客户端Excel的名称
        String filename = setName() + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xls";
        //处理中文文件名
        filename = MyUtils.encodeFilename(filename, request);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }


    public void setDataStart(int dataStart) {
        this.dataStart = dataStart;
    }

    public abstract String[] setTitle();

    public abstract String setName();

    public abstract HSSFCellStyle setTitleStyle(HSSFWorkbook workbook);

    public abstract HSSFCellStyle setColumnStyle(HSSFWorkbook workbook);

    public abstract void settings(HSSFSheet sheet);

    public abstract String[] setKey();

    public abstract String sumColumn();

    public void setDataMax(int dataMax) {
        this.dataMax = dataMax;
    }

    public abstract List<Map<String, Object>> data(Integer offset);

}
