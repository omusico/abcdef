package com.lvmama.lvfit.offline.common;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.lvmama.lvf.common.dto.BaseResponseDto;
import com.lvmama.lvf.common.form.Form;
import com.lvmama.lvfit.common.form.report.FitRecordSearchInputForm;
import com.lvmama.lvfit.common.form.report.FitRecordSearchResultForm;

public interface FitSearchRecordController <I extends Form, R extends BaseResponseDto<? extends Form>>  {
    public String index(Model m);
    public BaseResponseDto<FitRecordSearchResultForm> queryFitSearchRecord(FitRecordSearchInputForm inputForm);
    public void exportCsv(FitRecordSearchInputForm inputForm , HttpServletResponse response);
}
