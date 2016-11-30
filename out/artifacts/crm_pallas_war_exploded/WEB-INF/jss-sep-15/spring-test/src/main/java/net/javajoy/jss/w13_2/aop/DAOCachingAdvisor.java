package net.javajoy.jss.w13_2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cyril Kadomsky
 */

@Component
@Aspect
public class DAOCachingAdvisor {

    Map<Long,ValueObject> cache;

    public DAOCachingAdvisor() {
        cache = new HashMap<>(20);
    }

    @Pointcut("execution( * CustomerDAO.*(..))")
    public void anyMethodPointcut() {}

    @Pointcut("execution( public * CustomerDAO.get*(..))")
    public void voGetterPointcut() {}


    @Before("execution(* SimpleCustomerDAO.*(..))")
    public void anyAdvice(JoinPoint jp) {         // cannot prevent jp from proceeding
        System.out.println("method is about to be invoked : " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());

    }

    @Around("voGetterPointcut()")
    public Object voGetterAdvice(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("DAO getter is about to be invoked with id : " + Arrays.toString(jp.getArgs()) );
        Object retVal = null;
        Long id = (Long) jp.getArgs()[0];

        if (cache.containsKey(id)) {
            return cache.get(id);

        } else {

            retVal = jp.proceed();

            if ( retVal!= null && retVal instanceof ValueObject) {
                ValueObject vo = (ValueObject) retVal;
                cache.put( vo.getId(), vo );
            }
            return retVal;

        }
    }



}
