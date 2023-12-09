package com.supraja.NotesApplication.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class userLoginAspect {
    @Before("execution( * com.supraja.NotesApplication.controller.LoginController.showMyLoginPage())")
    public void beforeShowLoginForm() {
        System.out.println( "------------------A user is trying to login-------");
    }
}
