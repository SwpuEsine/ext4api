package zft.control.manager.tools;

import org.apache.commons.codec.binary.Hex;

import java.util.Random;

public class StringUtils {

    public static boolean isNotNull(Object str) {
        if (str instanceof String) {
            if (str != null && !"".equals(str)) {
                return true;
            } else {
                return false;
            }
        } else if (str instanceof Integer) {
            Integer tmp = Integer.parseInt((String) str);
            if (tmp != 0 && tmp != null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (str != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static String oTs(Object o) {
        return o != null ? o.toString() : "";
    }
    /**
     * 获取一定长度的随机字符串
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRstr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String bytesToHexString(byte[] bytes){
    	return Hex.encodeHexString(bytes);
    }
    public static String byteToHex(byte bytet){
    	byte[] bytearr= new byte[1];
    	bytearr[0]=bytet;
    	return Hex.encodeHexString(bytearr);
    }
    public static int byteToInt(byte[] bytes,int defalt){
    	int i =defalt;
    	try{
    		i=Integer.parseInt(Hex.encodeHexString(bytes));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	return i;
    	
    }
}
