package com.mg.aircondition.aspect;

import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.exception.CsException;
import com.mg.aircondition.exception.Exceptions;
import com.mg.aircondition.model.User;
import com.mg.aircondition.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class UserAspect {
    private final UserRepository userRepository;

    @Pointcut("@annotation(com.mg.aircondition.aspect.annotations.UserPhoneNumberExist)")
    public void createUserPointCut() {
    }

    @Pointcut("@annotation(com.mg.aircondition.aspect.annotations.UserExist)")
    public void userPointCut() {
    }

    @Before("createUserPointCut()")
    public void beforeCreateUser(JoinPoint joinPoint) {
        String phoneNumber = ((PostUserRequest) joinPoint.getArgs()[0]).getPhoneNr();
        if (isPhoneNumberExist(phoneNumber)) {
            throw new CsException(Exceptions.POST_USER_DUPLICATION);
        }
    }

    public boolean isPhoneNumberExist(String phoneNumber) {
        User user = userRepository.findUserByPhoneNr(phoneNumber);
        return user != null;
    }


    @Before("userPointCut()")
    public void beforeGetUser(JoinPoint joinPoint) {
        Integer user_id = (Integer) joinPoint.getArgs()[0];
        if (userRepository.findById(user_id).isEmpty()) {
            throw new CsException(Exceptions.USER_NOT_FOUND_ERROR);
        }
    }
}
