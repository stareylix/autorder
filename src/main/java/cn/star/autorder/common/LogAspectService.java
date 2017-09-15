package cn.star.autorder.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("logAopService")
@Aspect
public class LogAspectService {
	private Logger log=Logger.getLogger(LogAspectService.class);
	private String logStr=null;
	
	
	@Pointcut("execution(* cn.star.autorder.*.service.*.*(..))")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void dobefore(JoinPoint jp) {
		logStr="begin invoke method===>"+jp.getClass().getName()+"."+jp.getSignature().getName();
		log.debug(logStr);
	}
	
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long startTime=System.currentTimeMillis();
		Object result = pjp.proceed();
		logStr="method===>"+pjp.getClass().getName()+"."+pjp.getSignature().getName()
				+" ----->elapsed time:"+(System.currentTimeMillis()-startTime)+" ms";
		log.debug(logStr);
		return result;
	}
	
	@After("pointcut()")
	public void doAfter(JoinPoint jp) {
		logStr="end invoke method===>"+jp.getClass().getName()+"."+jp.getSignature().getName();
		log.debug(logStr);
	}
}
