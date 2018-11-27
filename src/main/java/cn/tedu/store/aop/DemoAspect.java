package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

@Component
//@Aspect表示类为切面类
@Aspect
public class DemoAspect {
	//@Before表示在业务方法之前执行的代码
	//bean(userService)表示横切的bean类为userService
	//userService表示Spring实例化bean的名称
	@Before("bean(userService)")
	public void test1() {
		System.out.println("业务方法之前执行。。");
	}
	//@After后置通知
	//（最终通知,不管有没有异常都要执行的方法）
	@After("bean(userService)")
	public void test2() {
		System.out.println("业务方法之后。。");
	}
	//后置通知
	//不发生异常，执行该通知
	@AfterReturning("bean(userService)")
	public void test3() {
		System.out.println("业务方法之后执行returning");
	}
	//发生异常时执行的通知
	@AfterThrowing("bean(userService)")
	public void test4() {
		System.out.println("异常通知。。");
	}
	//@Around
	//1.方法必须有返回值
	//2.必须有参数
	//3.必须把值返回
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("获取之前的系统时间");
		//开始时间
		long start = System.currentTimeMillis();
		//表示调用业务方法
		Object obj = pp.proceed();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("获取之后的系统时间");
		return obj;
	}
	
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object test6(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("??????");
		//表示调用业务方法
		Object obj = pp.proceed();
	
		return obj;
	}
}
