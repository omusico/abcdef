package com.lvmama.lvf.common.adapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Path{
	public String wsdl() default "";
	public String path() default "";
	public String namespace() default "";
	public Class service();
}
