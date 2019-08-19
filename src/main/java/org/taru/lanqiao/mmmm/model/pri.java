package org.taru.lanqiao.mmmm.model;

import java.util.List;

public class pri {
    private String priId;
    private String priName;
    private String priFatherId;
    private String priUrl;
    private String priStatus;
    List data;

    public String getPriId() {
        return priId;
    }

    public void setPriId(String priId) {
        this.priId = priId;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public String getPriFatherId() {
        return priFatherId;
    }

    public void setPriFatherId(String priFatherId) {
        this.priFatherId = priFatherId;
    }

    public String getPriUrl() {
        return priUrl;
    }

    public void setPriUrl(String priUrl) {
        this.priUrl = priUrl;
    }

    public String getPriStatus() {
        return priStatus;
    }

    public void setPriStatus(String priStatus) {
        this.priStatus = priStatus;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
