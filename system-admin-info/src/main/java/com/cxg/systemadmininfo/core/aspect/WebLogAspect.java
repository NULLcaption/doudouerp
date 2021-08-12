package com.cxg.systemadmininfo.core.aspect;

import cn.hutool.core.net.Ipv4Util;
import com.cxg.systemadmininfo.core.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/**
 * web端Log日志请求切面
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 声明一个切入点：在各个controller上
     */
    @Pointcut("execution( * com.cxg.systemadmininfo..controller.*.*(..))")
    public void logPointCut(){
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint){
        //接收请求，记录请求内容
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        logger.info("请求地址:"+httpServletRequest.getRequestURL().toString());
        logger.info("请求方法:"+httpServletRequest.getMethod());
        logger.info("请求IP:" + IpUtils.getIpAddr(httpServletRequest));
        logger.info("请求CLASS_METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("请求参数:" + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * returning的值和doAfterReturning的参数名一致
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        logger.debug("返回值 : " + ret);
    }


    /**
     * 既可以在目标方法之前织入增强动作，也可以在执行目标方法之后织入增强动作；
     * 可以决定目标方法在什么时候执行，如何执行，甚至可以完全阻止目标目标方法的执行；
     * 可以改变执行目标方法的参数值，也可以改变执行目标方法之后的返回值；
     * 当需要改变目标方法的返回值时，只能使用Around方法；
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        logger.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }

}
