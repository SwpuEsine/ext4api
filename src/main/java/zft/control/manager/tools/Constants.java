package zft.control.manager.tools;


public class Constants {
    public static final String SESSION_USER = "USER";
    public static final String SESSION_MENU = "MENU";
    public static final String SUCCESS = "000000";
    public static final int SELECT_LIMIT = 15;
    public static final String APP_DOWNLOAD_DISK;
    public static final String TASK_IMAGE_DISK;
    public static final String MCHT_DATA_DISK;
    public static final int SELECT_CACHE;


    static {
        APP_DOWNLOAD_DISK = SystemFiles.getSystem("APP_DOWNLOAD_DISK");
        TASK_IMAGE_DISK = SystemFiles.getSystem("TASK_IMAGE_DISK");
        MCHT_DATA_DISK = SystemFiles.getSystem("MCHT_DATA_DISK");
        SELECT_CACHE = Integer.parseInt(SystemFiles.getSystem("SELECT_CACHE"));
    }

    public class RedisKey {
        //菜单表key
        public static final String MENU_CACHE = "MENU_INF";

    }
}
