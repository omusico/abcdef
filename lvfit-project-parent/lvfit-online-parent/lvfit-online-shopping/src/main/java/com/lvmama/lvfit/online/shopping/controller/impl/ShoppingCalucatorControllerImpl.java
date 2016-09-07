package com.lvmama.lvfit.online.shopping.controller.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lvmama.lvf.common.dto.BaseResultDto;
import com.lvmama.lvf.common.dto.BaseSingleResultDto;
import com.lvmama.lvfit.common.client.FitDpClient;
import com.lvmama.lvfit.common.dto.enums.BookingSource;
import com.lvmama.lvfit.common.dto.request.CalculateAmountRequest;
import com.lvmama.lvfit.common.dto.request.CalculateProductPriceRequest;
import com.lvmama.lvfit.common.dto.request.CalculateSalesProductPriceRequest;
import com.lvmama.lvfit.common.dto.shopping.FitProductDto;
import com.lvmama.lvfit.common.dto.shopping.FitShoppingAmountDto;
import com.lvmama.lvfit.common.form.shopping.CalculateProductPriceRequestForm;
import com.lvmama.lvfit.online.base.BaseController;
import com.lvmama.lvfit.online.exception.BaseExceptionHandler;
import com.lvmama.lvfit.online.shopping.ShoppingCalucatorController;
import com.lvmama.lvfit.online.shopping.form.CalucateAmountRequestForm;


@Controller
@RequestMapping("shopping")
public class ShoppingCalucatorControllerImpl extends BaseController implements ShoppingCalucatorController{
	
	private Logger logger = LoggerFactory.getLogger(ShoppingCalucatorControllerImpl.class);
	
	@Autowired
	private FitDpClient fitDpClient;

	@Override
	@RequestMapping(value="/calucateAmount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public BaseSingleResultDto<FitShoppingAmountDto> calucateAmount(Model model,CalucateAmountRequestForm form,HttpServletRequest request){
		CalculateAmountRequest amountRequest = new CalculateAmountRequest();
		amountRequest.setShoppingUUID(form.getShoppingUUID());
		BaseSingleResultDto<FitShoppingAmountDto> baseResultDto =new BaseSingleResultDto<FitShoppingAmountDto>();

		if(this.getIsBackBooking(request).booleanValue()){
			amountRequest.setBookingSource(BookingSource.FIT_BACK);
		}else{
			amountRequest.setBookingSource(BookingSource.FIT_FRONT);
		}
		
	    baseResultDto =  fitDpClient.calculateAmount(amountRequest);
		return baseResultDto;
		
	}
	
	@Override
	@RequestMapping(value="/calulateProductPrice", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public float calulateProductPrice(@RequestBody CalculateProductPriceRequestForm reqForm) {
	    List<FitProductDto> products = reqForm.getProducts();
	    BigDecimal productPrice = new BigDecimal(0);
	    for (FitProductDto product : products) {
	        BigDecimal singlePrice = new BigDecimal(product.getPrice());
	        BigDecimal count = new BigDecimal(product.getCount());
	        BigDecimal price = singlePrice.multiply(count);
	        productPrice = productPrice.add(price);
	    }
	    return productPrice.floatValue();
	}
	
	@Override
    @RequestMapping(value="/calulateSalesPrice", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public float calulateSalesPrice(CalculateSalesProductPriceRequest req) {
	    BigDecimal comboPrice = req.getComboPrice() == null ? BigDecimal.valueOf(0) : req.getComboPrice();
	    BigDecimal productPrice = req.getProductPrice() == null ? BigDecimal.valueOf(0) : req.getProductPrice();
	    BigDecimal discountPrice = req.getDiscountPrice() == null ? BigDecimal.valueOf(0) : req.getDiscountPrice();
	    
        return comboPrice.add(productPrice).subtract(discountPrice).floatValue();
    }
}
