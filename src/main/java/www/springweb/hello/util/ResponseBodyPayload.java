package www.springweb.hello.util;

/**
 * Ajax请求返回值
 * 
 */
public class ResponseBodyPayload {

    /** 成功状态,默认 */
    private Boolean success = true;

    /** 成功信息 */
    private String succeMsg = "";

    /** 失败信息 */
    private String errorMsg = "";

    /** 成功数据 */
    private Object succeResData;

    /** 失败数据 */
    private Object errorResData;

    // getters and setters

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getSucceMsg() {
        return succeMsg;
    }

    public void setSucceMsg(String succeMsg) {
        this.succeMsg = succeMsg;
        this.success = Boolean.TRUE;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        this.success = Boolean.FALSE;
    }

    public Object getSucceResData() {
        return succeResData;
    }

    public void setSucceResData(Object succeResData) {
        this.succeResData = succeResData;
        this.success = Boolean.TRUE;
    }

    public Object getErrorResData() {
        return errorResData;
    }

    public void setErrorResData(Object errorResData) {
        this.errorResData = errorResData;
        this.success = Boolean.FALSE;
    }

}
