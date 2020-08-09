package com.jiangtf.demo.protocal;

import java.io.Serializable;

public class Resp implements Serializable {
    private static final long serialVersionUID=-4546652381492921069L;
    private String id;//唯一ID
    private String type;//传输对象的类型
    private String tag;//操作类型
    private String responseCode;
    private String responseMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
