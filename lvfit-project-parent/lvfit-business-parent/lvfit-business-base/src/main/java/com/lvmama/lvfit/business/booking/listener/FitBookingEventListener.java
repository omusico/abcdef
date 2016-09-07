package com.lvmama.lvfit.business.booking.listener;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lvmama.lvf.common.event.Event;
import com.lvmama.lvf.common.event.EventListener;
import com.lvmama.lvfit.business.booking.service.FitBookingFinService;
import com.lvmama.lvfit.business.booking.service.FitFlightBookingService;
import com.lvmama.lvfit.business.booking.service.FitVstBookingService;
import com.lvmama.lvfit.common.dto.order.FitOrderMainDto;

/**
 * 预订服务事件监听
 *
 * @author qihuisong
 */
@Component
public class FitBookingEventListener implements EventListener {
	
	private static Logger logger = LoggerFactory.getLogger(FitBookingEventListener.class);

	@Autowired
	private FitVstBookingService fitVstBookingService;

	@Autowired
	private FitBookingFinService fitBookingFinService;

	@Autowired
	private FitFlightBookingService fitFlightBookingService;

	@Override
	@PostConstruct
	public void register() {

		Event.ORDER_BOOKING.register(this);
		logger.info("register event：" + Event.ORDER_BOOKING);

		Event.SUPPORDER_BOOKING.register(this);
		logger.info("register event：" + Event.SUPPORDER_BOOKING);

		Event.ORDER_BOOKING_FINISH.register(this);
		logger.info("register event：" + Event.ORDER_BOOKING_FINISH);
	}

	@Override
	public void handler(Event event, Object context) {

		logger.info("handler event：" + event);

		if (null == event || null == context)
			return;

		switch (event) {
			case ORDER_BOOKING:
				fitVstBookingService.vstBooking((FitOrderMainDto) context);
				break;
			case SUPPORDER_BOOKING:
				fitFlightBookingService.flightBooking((FitOrderMainDto) context);
				break;
			case ORDER_BOOKING_FINISH:
				fitBookingFinService.finishBooking((FitOrderMainDto) context);
				break;
			default:
				break;
		}
	}
}
