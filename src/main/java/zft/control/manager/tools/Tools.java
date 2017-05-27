package zft.control.manager.tools;


import com.alibaba.fastjson.JSONArray;
import zft.control.manager.objs.view.ResponseBase;
import zft.control.manager.objs.view.SelectArray;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tools {
    public static final SimpleDateFormat spf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat spf2 = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat spf3 = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat spf4 = new SimpleDateFormat("yyyy-MM-dd");

    private Tools(){}
    public static ResponseBase returnWeb(String errCode, String... errMsg) {
        ResponseBase res = new ResponseBase();
        res.setResult_code(errCode);
        res.setResult_msg(SystemFiles.getCode(errCode, errMsg));
        return res;
    }

    public static String getDateTime() {
        return spf.format(new Date());
    }

    public static String getDate() {
        return spf2.format(new Date());
    }

    //apk下载文件读取
    public static File[] loadFile() {
        File directory = new File(Constants.APP_DOWNLOAD_DISK);
        if (!directory.exists()) {
            directory.mkdirs();
            return new File[0];
        }
        return directory.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().startsWith("android") && file.getName().endsWith(".apk");
            }
        });
    }

    public static String getWebLoginId(String userId) {
        return "WEB_" + userId;
    }

    /**
     * BeanUtils.copyProperties 空值不copy
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static String formatDate8(String date) {
        if (!StringUtils.isNotNull(date))
            return date;
        try {
            return spf4.format(spf2.parse(date));
        } catch (ParseException e) {
            return date;
        }
    }

    public static void formatSelect(List<Map<String, Object>> mapList, SelectArray select) {
        String data = JSONArray.toJSONString(mapList);
        List<SelectArray.Select> list = JSONArray.parseArray(data, SelectArray.Select.class);
        select.setItems(list);
    }

}
