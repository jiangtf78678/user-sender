package com.jiangtf.demo.protocal;

import java.io.Serializable;

public class Req implements Serializable {
    private static final long serialVersionUID=-2577707401136472809L;
    private String id;//唯一ID
    private String type;//传输对象的类型
    private String tag;//操作类型
    private String reqeustMessage;//json对象

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

    public String getReqeustMessage() {
        return reqeustMessage;
    }

    public void setReqeustMessage(String reqeustMessage) {
        this.reqeustMessage = reqeustMessage;
    }
}
