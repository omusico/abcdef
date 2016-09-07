package com.lvmama.lvfit.common.dto.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.lvmama.lvf.common.solr.json.base.criteria.annotation.SolrField;
import com.lvmama.lvf.common.solr.json.base.criteria.enums.SolrQueryTYPE;
import com.lvmama.lvf.common.utils.DateUtils;
import com.lvmama.lvfit.common.dto.search.FitRecordSearchIndex;

@XmlRootElement
public class FitRecordSearchRequest implements Serializable {

    private static final long serialVersionUID = 3047260792193229234L;

    private FitRecordSearchIndex fitRecordSearchIndex = new FitRecordSearchIndex();

    private String selectTimeStart;

    private String selectTimeEnd;
    
    private String resultStatus;
    
    public FitRecordSearchRequest() {
        super();
    }
    
    public FitRecordSearchRequest(FitRecordSearchIndex fitRecordSearchIndex) {
        super();
        this.fitRecordSearchIndex = fitRecordSearchIndex;
    }

    @SolrField(name = "departureCityCode", type = SolrQueryTYPE.EQ)
    public String getDepartureCityCode() {
        return fitRecordSearchIndex.getDepartureCityCode();
    }

    @SolrField(name = "arrivalCityCode", type = SolrQueryTYPE.EQ)
    public String getArrivalCityCode() {
        return fitRecordSearchIndex.getArrivalCityCode();
    }

    @SolrField(name = "departureDate", type = SolrQueryTYPE.EQ)
    public String getDepartureDate() {
        return fitRecordSearchIndex.getDepartureDate();
    }

    @SolrField(name = "returnDate", type = SolrQueryTYPE.EQ)
    public String getReturnDate() {
        return fitRecordSearchIndex.getReturnDate();
    }

    @SolrField(name = "stayCityCode", type = SolrQueryTYPE.EQ)
    public String getStayCityCode() {
        return fitRecordSearchIndex.getStayCityCode();
    }

    @SolrField(name = "checkInDate", type = SolrQueryTYPE.EQ)
    public String getCheckInDate() {
        return fitRecordSearchIndex.getCheckInDate();
    }

    @SolrField(name = "checkOutDate", type = SolrQueryTYPE.EQ)
    public String getCheckOutDate() {
        return fitRecordSearchIndex.getCheckOutDate();
    }

    @SolrField(name = "queryTime", type = SolrQueryTYPE.BETWEEN)
    public Long getQueryTimeStartLong() {
        if(StringUtils.isNotBlank(this.selectTimeStart)){
            return DateUtils.parseCnHmDate(this.selectTimeStart).getTime();
        }else{
            return 0L;
        }
    }

    @SolrField(name = "queryTime", type = SolrQueryTYPE.BETWEEN)
    public Long getQueryTimeEndLong() {
        if(StringUtils.isNotBlank(this.selectTimeEnd)){
            return DateUtils.parseCnHmDate(this.selectTimeEnd).getTime();
        }else{
            return Long.MAX_VALUE;
        }
    }
    
    @SolrField(name = "resultStatus", type = SolrQueryTYPE.EQ)
    public String getResultStatus() {
        return this.resultStatus;
    }
    
    @SolrField(name = "ip", type = SolrQueryTYPE.PREFIX)
    public String getIp() {
        return fitRecordSearchIndex.getIp();
    }

    public void setDepartureCityCode(String departureCityCode) {
        fitRecordSearchIndex.setDepartureCityCode(departureCityCode);
    }

    public void setArrivalCityCode(String arrivalCityCode) {
        fitRecordSearchIndex.setArrivalCityCode(arrivalCityCode);
    }

    public void setDepartureDate(String departureDate) {
        fitRecordSearchIndex.setDepartureDate(departureDate);
    }

    public void setReturnDate(String returnDate) {
        fitRecordSearchIndex.setReturnDate(returnDate);
    }

    public void setStayCityCode(String stayCityCode) {
        fitRecordSearchIndex.setStayCityCode(stayCityCode);
    }

    public void setCheckInDate(String checkInDate) {
        fitRecordSearchIndex.setCheckInDate(checkInDate);
    }

    public void setCheckOutDate(String checkOutDate) {
        fitRecordSearchIndex.setCheckOutDate(checkOutDate);
    }

    public void setSelectTimeStart(String selectTimeStart) {
        this.selectTimeStart = selectTimeStart;
    }

    public void setSelectTimeEnd(String selectTimeEnd) {
        this.selectTimeEnd = selectTimeEnd;
    }
    
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }
    
    public String getSelectTimeStart() {
        return this.selectTimeStart;
    }
    
    public String getSelectTimeEnd() {
        return this.selectTimeEnd;
    }

    public void setIp(String ip) {
        fitRecordSearchIndex.setIp(ip);
    }

}
