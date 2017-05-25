package zft.control.manager.objs.view;

import zft.control.manager.tools.SystemFiles;

public class ResponseBase {

    public ResponseBase() {

    }

    public ResponseBase(String code) {
        this.result_code = code;
        this.result_msg = SystemFiles.getCode(code);
    }

    public ResponseBase(String code, String message) {
        this.result_code = code;
        this.result_msg = message;
    }

    /**
     * 响应吗
     */
    private String result_code;

    /**
     * 响应信息
     */
    private String result_msg;

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }
}
