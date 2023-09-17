package com.mg.aircondition.mapper;

import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.model.User;
import org.h2.engine.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void mapFromPutUserRequestToUser_Test() {
        //Given
        PutUserRequest putUserRequest = new PutUserRequest()
                .phoneNr("11221")
                .addresses(new ArrayList<>());

        User user = User.builder()
                .id(12)
                .role("CUSTOMER_ROLE")
                .birthDate("12-2121")
                .build();

        //ACT
       userMapper.fromPutUserRequestToUser(user,putUserRequest);

        System.out.println(user);
        //assert
        Assertions.assertEquals(12, user.getId());
        Assertions.assertEquals("CUSTOMER_ROLE", user.getRole());
        Assertions.assertEquals("11221", user.getPhoneNr());
    }
}
