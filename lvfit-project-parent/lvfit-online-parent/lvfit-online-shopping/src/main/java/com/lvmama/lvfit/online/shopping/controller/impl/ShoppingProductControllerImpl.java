package com.lvmama.lvfit.online.shopping.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.lvmama.lvf.common.exception.ExceptionCode;
import com.lvmama.lvf.common.exception.ExceptionWrapper;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvf.common.utils.JSONMapper;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.request.FitShoppingFliInsRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingInsuranceRequest;
import com.lvmama.lvfit.common.dto.request.FitShoppingTicketRequest;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingSelectedInsuranceDto;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingProcductController;

@Controller
@RequestMapping("shopping")
public class ShoppingProductControllerImpl extends BaseExceptionHandler implements ShoppingProcductController<FitShoppingTicketRequest> {
	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(ShoppingProductControllerImpl.class);
    @Autowired
    FitDpClient fitDpClient;
    
    /**
     * 更新购物车中选中的景点信息
     */
    @Override
    @ResponseBody
    @RequestMapping(value="/updSelectedTicket")
    public void updSelectedTicket(FitShoppingTicketRequest req) {
        fitDpClient.updSelectedTicketInfo(req);
    }
    
    /**
     * 更新购物车中选中的保险信息
     */
    @Override
    @ResponseBody
    @RequestMapping(value="/updSelectedInsurance")
    public void updSelectedInsurance(FitShoppingInsuranceRequest req) {
        Map<String, String> map = new HashMap<String, String>();
    	JavaType javaType = JSONMapper.getInstance().getTypeFactory().constructParametricType(ArrayList.class, FitShoppingSelectedInsuranceDto.class);
    	List<FitShoppingSelectedInsuranceDto> insuranceList = new ArrayList<FitShoppingSelectedInsuranceDto>();
		try {
			insuranceList = (List<FitShoppingSelectedInsuranceDto>)JSONMapper.getInstance().readValue(req.getInsuranceList(), javaType);
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
		req.setInsuranceDtoList(insuranceList);
		fitDpClient.updSelectedInsuranceInfo(req);
    }

    /**
     * 根据购物车uuid获取购物车信息
     */
    @Override
    @ResponseBody
    @RequestMapping(value="/getShoppingInfo")
    public FitShoppingDto getShoppingDtoByCache(@RequestParam String shoppingUuid) {
        if (shoppingUuid == null) {
            throw new ExceptionWrapper(ExceptionCode.GET_NO_CACHE_SHOPPING);
        }
        BaseSingleResultDto<FitShoppingDto> result = fitDpClient.getShoppingByUUID(shoppingUuid);
        return result.getResult();
    }


    /**
     * 更新购物车中选中航意险信息
     */
    @Override
    @ResponseBody
    @RequestMapping(value="/updSelectedFliIns")
    public void updSelectedTicket(FitShoppingFliInsRequest req) {
        fitDpClient.updSelectedFliInsInfo(req);
    }
}
