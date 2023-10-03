package petmembership.common;

import lombok.Data;

public enum BusCodeEnum {

    SUCCESS(0, "SUCCESS"),

    SYSTEM_ERROR(10000, "SYSTEM ERROR"),

    DUPLICATION_OF_DATA(50001, "DATA WITH THE SAME KEY ALREADY EXISTS"),

    MANDATORY_FIELD(50002, "MANDATORY FIELD IS EMPTY"),

    INVALID_INPUT(50003, "INPUT IS INVALID"),

    NONE_FOUND(50004, "NO RECORD FOUND");

    private int code;
    private String msg;

    BusCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
