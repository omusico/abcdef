package com.lvmama.lvf.common.trace.profile;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD })
public @interface ProfilePoint{

	public Profile value();
	
}
