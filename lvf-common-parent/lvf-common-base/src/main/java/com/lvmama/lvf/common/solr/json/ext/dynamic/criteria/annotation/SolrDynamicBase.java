package com.lvmama.lvf.common.solr.json.ext.dynamic.criteria.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface SolrDynamicBase {
	String name();
}
