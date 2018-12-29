package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	// 定义切点
	@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance() {
	}

	/*// 表演之前-手机静音
	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Slilence cell phones");
	}

	// 表演之前-坐好座位
	@Before("performance()")
	public void takeSeats() {
		System.out.println("Taking seats");
	}

	// 表演中间-鼓掌
	@AfterReturning("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP");
	}

	// 表演失败-要求退票
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}*/
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silence cell phones");
			System.out.println("Taking seat");
			jp.proceed();
			System.out.println("CLAP CLAP CLAP");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}
}
