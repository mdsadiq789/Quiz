package com.fibr.quiz.interceptor;

import com.fibr.quiz.repository.AccessTokenRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccessTokenInterceptor {

    private InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    @Autowired
    private AccessTokenRepository repo;

    @Before("@within(com.fibr.quiz.annotation.AccessTokenAuth) "
            + "|| @annotation(com.fibr.quiz.annotation.AccessTokenAuth)")
    public void authenticate(JoinPoint joinPoint) throws Exception {
        threadLocal.set(null);
        String accessToken = RequestInterceptor.getHeader("access-token");
        if (accessToken == null || !repo.existsByAccessToken(accessToken))
            throw new Exception("Invalid Channel Id");
        threadLocal.set(accessToken);
    }

    public String getAccessToken() {
        return threadLocal.get();
    }
}
