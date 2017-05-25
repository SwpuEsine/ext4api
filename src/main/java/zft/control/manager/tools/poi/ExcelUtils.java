package zft.control.manager.tools.poi;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelUtils {

    public static HSSFCellStyle styleCell(HSSFWorkbook workbook, int fontSize, boolean isBold, boolean isCenter) {
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        HSSFFont font = workbook.createFont();
        if (isCenter) {
            style.setAlignment(HorizontalAlignment.CENTER); // 水平布局：居中
            style.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        font.setBold(isBold);
        font.setFontHeightInPoints((short) fontSize);
        style.setFont(font);
        return style;
    }

    public static HSSFCellStyle styleTitleCell(HSSFWorkbook workbook, int fontSize, boolean isBold, boolean isCenter) {
        HSSFCellStyle style = styleCell(workbook, fontSize, isBold, isCenter);
        style.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    public static void setRegionStyle(CellStyle cs, CellRangeAddress region, Sheet sheet) {
        for (int i = region.getFirstRow(); i <= region.getLastRow(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) row = sheet.createRow(i);
            for (int j = region.getFirstColumn(); j <= region.getLastColumn(); j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell(j);
                    cell.setCellValue("");
                }
                cell.setCellStyle(cs);
            }
        }
    }
}
