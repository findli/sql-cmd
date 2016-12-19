package jss.w13_2.aop;

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
 * spring аспекты не добавляет к сеттерам  и геттерам
 */
@Component
@Aspect
public class DAOCachingAdvisor {
    Map<Long, ValueObject> cache;

    public DAOCachingAdvisor() {
        cache = new HashMap<>(20);
    }

    /**
     * execution(* звездочка означает любой тип возвр значения и идентификатор доступа
     * public * functionName
     * <p>
     * в скобках метода типы параметров или .. или () - только без параметров
     * <p>
     * && another execution()
     */
//    @Pointcut("execution(* CustomerDAO.*(long ))")
    @Pointcut("execution(* CustomerDAO.*(..))")
    public void anyMethodPointcut() {
    }

    @Pointcut("execution( public * CustomerDAO.get*(..))")
    public void voGetterPointcut() {
    }

    @Before("execution(* SimpleCustomerDAO.*(..))")
    public void anyAdvice(JoinPoint joinPoint) {// cannot prevent jp from proceeding
        System.out.println("method is about to be invoked : " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * можно прям тут определить фильтр
     *
     * все кроме @Around сами вызывают target method, в тут надо {@link ProceedingJoinPoint}.proceed()
     */
    @Around("voGetterPointcut()")
    public Object voGetterAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("DAO getter is about to be invoked with id : " + Arrays.toString(proceedingJoinPoint.getArgs()));
        Object retVal = null;
        Long id = (Long) proceedingJoinPoint.getArgs()[0];

        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            retVal = proceedingJoinPoint.proceed();

            if (retVal != null && retVal instanceof ValueObject) {
                ValueObject valueObject = (ValueObject) retVal;
                cache.put(valueObject.getId(), valueObject);
            }

            return retVal;
        }
    }
}
