package aop02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PersonAspect {
	
	@Pointcut(value = "execution(public * aop02.*.doSomething(..))")
	public void pt() {}
	
	@Before("pt()")
	public void doBefore() {
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	@AfterReturning(value = "pt()", returning = "rt")
	public void doAfterReturning(String rt) {
		System.out.println(rt + " : 불을 끄고 잔다.");
	}
	
	@AfterThrowing(value = "pt()", throwing = "th")
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119에 신고한다.");
	}
	
	@After("pt()")
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}
	
}
