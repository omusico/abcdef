package com.lvmama.lvf.common.cache;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD })
public @interface CachePoint{

	public CacheBoxConvert value();
	public String cacheExpireTimeKey() default "";
	public int cacheSizeLimit() default 1000;	
	

}
