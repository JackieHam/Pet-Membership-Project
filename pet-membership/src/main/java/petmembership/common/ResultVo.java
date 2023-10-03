package petmembership.common;

import lombok.Data;

@Data
public class ResultVo {

    private int code;

    private String msg;


    private  Object Data;


    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        Data = data;
    }
}
