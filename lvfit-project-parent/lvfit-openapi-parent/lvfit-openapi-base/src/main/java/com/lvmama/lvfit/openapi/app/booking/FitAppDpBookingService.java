package com.lvmama.lvfit.openapi.app.booking;

import com.lvmama.lvfit.common.dto.app.FitAppBookingRequest;
import com.lvmama.lvfit.common.dto.app.FitAppOrderDto;

public interface FitAppDpBookingService {

	FitAppOrderDto booking(FitAppBookingRequest appBookingRequest);

}
