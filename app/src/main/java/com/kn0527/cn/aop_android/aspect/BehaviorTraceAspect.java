package com.kn0527.cn.aop_android.aspect;

import android.util.Log;

import com.kn0527.cn.aop_android.annotation.BehaviorTrace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * auto：xkn on 2018/3/9 18:04
 * joinPints 可以看做是程序运行时的一个执行点 比如说一个函数的调用可以
 * 看做是个joinPionts，相当于代码切入点
 *
 * @Before: Advice通知 具体的插入点
 * execution: 处理joinPoint的类型，例如call、execution
 * (* android.app.Activity.mShake**(..)) 这个是最重要的表达式，第一个*表示返回值，
 * *表示返回值为任意类型，后面这个就是典型的包名路径，其中可以包含 *来进行通配，
 * 几个 *没有区别。同时这里可以通过&&、||、！来进行条件组合。（）代表这个方法的参数，
 * 你可以指定类型，例如android.os.Bundle,或者 (..) 这样来代表任意类型、任意个数的参数
 * public void onActivityMethodBefore 实际切入的代码
 * Before 和After 就是在Pointcuts之前和之后。  Android中就是在方法前后插入代码
 */
@Aspect
public class BehaviorTraceAspect {
    private static final String TAG = "KnTest";


    /**
     * 创建切入点
     * @throws Throwable
     * @Pointcut 一个程序会有多个Join Points,即使同一个函数，也还分为call 和 execution 类型的Join Points，
     * 但并不是所有的Join Points 都是我们关心的，Pointcuts 就是提供一种使得开发者能够只选择所需的JoinPoints的方法
     *  execution: 注释名 注释用的地方
     *  () 代表这个方法的参数  (...) 代表任意类型、任意个数的参数
     *  public void methodAnnotatedWithBehaviorTrace() 实际切入的代码
     */
    @Pointcut("execution(@com.kn0527.cn.aop_android.annotation.BehaviorTrace * *(..))")
    public void methodAnnotatedWithBehaviorTrace() throws Throwable {}

    /**
     * 对进入切面的内容如何处理
     *  advice
     *  @Before()  在切入点之前运行
     *  @After()   在切入点之后运行
     *  @Around()  在切入点前后都运行
     */
    @Around("methodAnnotatedWithBehaviorTrace()")
    public Object  behaviorTraceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature=(MethodSignature)joinPoint.getSignature();//获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
        String className=methodSignature.getDeclaringType().getSimpleName();//获取方法所属类的简单类名
        String methodName=methodSignature.getName();
        String funName=methodSignature.getMethod().getAnnotation(BehaviorTrace.class).value();
        //统计时间
        long begin=System.currentTimeMillis();
        //执行方法
        Object result=joinPoint.proceed();
        long duration=System.currentTimeMillis()-begin;
        Log.d("jett",String.format("功能：%s,%s类的%s方法执行了，用时%d ms",funName,className,methodName,duration));
        return result;
    }

}
