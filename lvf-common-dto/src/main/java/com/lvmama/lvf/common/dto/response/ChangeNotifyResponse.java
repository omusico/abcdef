package com.lvmama.lvf.common.dto.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ChangeNotifyResponse")
public class ChangeNotifyResponse {

    @XmlElement(name = "RetValue")
    private int retValue;//是否接收到航变通知,0:收到通知

    public ChangeNotifyResponse(int retValue) {
        this.retValue = retValue;
    }

    public ChangeNotifyResponse() {}
}
