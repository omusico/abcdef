package com.lvmama.lvfit.common.aspect.suppinterface;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lvmama.lvf.common.dto.enums.InterfaceKey;

@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD })
public @interface SuppInterfacePoint{

	public InterfaceKey value();
	
}
