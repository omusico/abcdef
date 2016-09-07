package com.lvmama.lvf.common.dto.md;


import com.lvmama.lvf.common.dto.Entity;

import java.io.Serializable;
import java.util.Date;

public class AppData extends Entity implements Serializable{

    private String sign;

    private String data;

    private String requestApi;

    /** 过期时间(分钟)*/
    private Integer expire;

    private Date lastCreated;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRequestApi() {
        return requestApi;
    }

    public void setRequestApi(String requestApi) {
        this.requestApi = requestApi;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public Date getLastCreated() {
        return lastCreated;
    }

    public void setLastCreated(Date lastCreated) {
        this.lastCreated = lastCreated;
    }
}
