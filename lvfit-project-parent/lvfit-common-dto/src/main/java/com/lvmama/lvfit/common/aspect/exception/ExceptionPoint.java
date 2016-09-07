package com.lvmama.lvfit.common.aspect.exception;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.lvmama.lvfit.common.dto.enums.FitBusinessExceptionType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD })
public @interface ExceptionPoint{

	public FitBusinessExceptionType value();
	
}
