package aop01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("aspect")
public class PersonAspect {
	
	public void doBefore(JoinPoint jp) {
		// JointPoint는 Advice를 적용할 수 있는 지점을 의미
		// JoinPoint를 매개변수로 주면 포인트컷에 대한 정보를 확인할 수 있음
		System.out.println("- signature : " + jp.getSignature());
		// 포인트컷이 발생한 객체도 받을 수 있음
		Object target = jp.getTarget();
		
		System.out.println("문을 열고 집에 들어간다.");
	}
	
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}
	
	public void doAfterReturning(String rt) {
		System.out.println("불을 끄고 잔다.");
		System.out.println("- rt : " + rt);
	}
	
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage() + " : 119에 신고한다.");
	}
	
	public void doAround(ProceedingJoinPoint jp) {
		// ProceedingJoinPoint은 발생한 포인트컷에 대한 정보와 제어권을 갖고 있는 객체
		doBefore(jp);
		try {
			String rt = (String) jp.proceed(); // 포인트컷이 발생한 메소드 실행
			doAfterReturning(rt);
		} catch (Throwable e) {
			doAfterThrowing(e);
		} finally {
			doAfter();
		}
	}
	
}
