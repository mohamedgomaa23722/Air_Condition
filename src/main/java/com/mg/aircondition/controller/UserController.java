package com.mg.aircondition.controller;

import com.mg.aircondition.api.UsersApi;
import com.mg.aircondition.dto.GetUserResponse;
import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.dto.StatusResponse;
import com.mg.aircondition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class UserController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<StatusResponse> createUser(PostUserRequest postUserRequest) {
        StatusResponse statusResponse = userService.createUser(postUserRequest);
        return ResponseEntity.ok(statusResponse);
    }

    @Override
    public ResponseEntity<StatusResponse> deleteUser(Integer id, String xToken) {
        StatusResponse statusResponse = userService.deleteUser(id, xToken);
        return ResponseEntity.ok(statusResponse);
    }

    @Override
    public ResponseEntity<GetUserResponse> getUser(Integer id, String xToken) {
        GetUserResponse userResponse = userService.getUser(id, xToken);
        return ResponseEntity.ok(userResponse);
    }

    @Override
    public ResponseEntity<List<GetUserResponse>> getUsers(String xToken) {
        List<GetUserResponse> users = userService.getUsers(xToken);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<StatusResponse> updateUser(Integer id, String xToken, PutUserRequest putUserRequest) {
        StatusResponse statusResponse = userService.updateUser(id, xToken, putUserRequest);
        return ResponseEntity.ok(statusResponse);
    }
}
