package com.lvmama.lvf.common.adapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OutputType {
	public Class value();
	public String method() default "";
}
