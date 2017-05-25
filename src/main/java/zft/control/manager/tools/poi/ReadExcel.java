
package zft.control.manager.tools.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public List<String[]> readExcel(String fileName, InputStream stream) throws IOException {
        if (fileName.endsWith(".xls")) {
            return readXls(stream);
        } else if (fileName.endsWith(".xlsx")) {
            return readXlsx(stream);
        }
        stream.close();
        return null;
    }

    /**
     * XLSX excel 导入
     *
     * @param is
     * @return
     * @throws IOException
     */
    private List<String[]> readXlsx(InputStream is) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<String[]> list = new ArrayList<>();
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        if (xssfSheet == null) {
            return null;
        }
        String[] obj;
        int celNum = 0;
        for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (rowNum == 0) {
                celNum = xssfRow.getLastCellNum();
            }
            obj = new String[celNum];
            for (int i = 0; i < celNum; i++) {
                obj[i] = getValue(xssfRow.getCell(i));
            }
            list.add(obj);
        }
        return list;
    }

    /*
    *xls excel 导入
     */
    private List<String[]> readXls(InputStream is) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<String[]> list = new ArrayList<>();
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        if (hssfSheet == null) {
            return null;
        }
        String[] obj;
        int celNum = 0;
        for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (rowNum == 0) {
                celNum = hssfRow.getLastCellNum();
            }
            obj = new String[celNum];
            for (int i = 0; i < celNum; i++) {
                obj[i] = getValue(hssfRow.getCell(i));
            }
            list.add(obj);
        }

        return list;
    }


    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow == null)
            return "";

        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("#.#####");
            String strCell = df.format(xssfRow.getNumericCellValue());
            return strCell;
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell == null)
            return "";

        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("#.#####");
            String strCell = df.format(hssfCell.getNumericCellValue());
            return strCell;
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}