package com.lvmama.lvf.cat.annotation;

/**
 * @author Tifancy
 * @version V1.0
 * @Title: ${file_name}
 * @Package: com.lvmama.cat.annotation
 * @Description: CAT非侵入埋点,后面可以扩充注解,实现metric
 * @date 2016/3/3  20:09
 */
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
public @interface TransactionTrace {

    String value() default "";

}
