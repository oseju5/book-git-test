package com.yonsai.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// AOP 설정 클래스

@Aspect  	// AOP 선언
@Component  // 객체 생성
public class LogAspect {

	// @Before 메서드 실행 전 동작 (현재 프로젝트 내 모든 메서드)
	//     void 타입으로 작성한다.
	@Before("execution(* com.yonsai.book..*(..))")
	public void beforeMethod(JoinPoint jp) {
		// JoinPoint : 단순 지점 정보를 가짐. @Before, @After에서 사용
		
		// 현재 메서드가 속한 클래스의 이름을 문자열로 반환
		String className = jp.getSignature().getDeclaringTypeName();
		
		// 클래스에 포함된 이름을 조건으로 layer 설정
		String layer = "";
		if (className.contains(".controller.")){
			layer = "Controller";
		} else if (className.contains(".service.")) {
			layer = "Service";
		} else if (className.contains(".repository.")) {
			layer = "Repository";
		}
		
		System.out.println("[AOP] -> 시작됨 " + layer + " - " + jp.getSignature().getName());
		
	}
	
	// @Around 메서드 실행 전/후 동작 (현재 프로젝트 내 모든 메서드)
	//     Object 타입으로 작성한다. (Aspect한 값을 컨트롤러/서비스에게 돌려주기 위해)
	@Around("execution(* com.yonsai.book..*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		
		// 전달받은 매개변수를 출력
		Object[] args = pjp.getArgs();
		for (Object a : args) {
			System.out.println(">>> [Before] 매개변수: " + a);
		}
		
		// 전달하는 반환값을 출력
		// 1. 타겟 메서드 실행 (jp에는 이 함수가 없음. 에러 방지를 위한 throws 필요)
		Object result = pjp.proceed();
		
		// 2. 반환값 출력
		System.out.println("<<< [After] 반환값: " + result);
		
		// 3. 결과값 반환 (반드시 돌려줘야 컨트롤러/서비스가 값을 사용할 수 있음!)
		return result;
	}
}
