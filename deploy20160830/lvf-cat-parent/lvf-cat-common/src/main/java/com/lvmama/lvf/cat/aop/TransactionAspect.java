package com.lvmama.lvf.cat.aop;


import com.dianping.cat.Cat;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Title: ${file_name}
 * @Package: com.lvmama.cat.transaction
 * @Description:
 * @date 2016/3/3  20:04
 */
@Aspect
@Component
public class TransactionAspect {

    public static Logger logger = LoggerFactory.getLogger(TransactionAspect.class);

    private static final ThreadLocal<Cat.Context> CAT_CONTEXT = new ThreadLocal<Cat.Context>();

    @Around("@annotation(com.lvmama.lvf.cat.annotation.TransactionTrace)")
    public Object TransactionTrace(ProceedingJoinPoint pjp) {

        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;

    }



}
