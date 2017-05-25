package zft.control.manager.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 获取错误码属性
 */
public class SystemFiles {
    private static Properties code = new Properties();
    private static Properties system = new Properties();

    static {
        try {
            code.load(new InputStreamReader(new FileInputStream(SystemFiles.class.getResource("/code.properties").getPath()), "UTF-8"));
            system.load(new InputStreamReader(new FileInputStream(SystemFiles.class.getResource("/system.properties").getPath()), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCode(String key, String... val) {
        String msg = code.getProperty(key);
        for (int i = 0; i < val.length; i++) {
            msg = msg.replace("{" + i + "}", val[i]);
        }
        return msg;
    }

    public static String getSystem(String key) {
        String msg = system.getProperty(key);
        return msg;
    }
}
