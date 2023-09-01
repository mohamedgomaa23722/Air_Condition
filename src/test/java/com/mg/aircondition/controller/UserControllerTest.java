package com.mg.aircondition.controller;

import com.mg.aircondition.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllUsers_Happy() throws Exception {
        when(userService.getUsers(any()))
                .thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(APPLICATION_JSON_VALUE)
                        .accept(APPLICATION_JSON_VALUE)
                        .header("x-token", "gomaaassaf45454"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
