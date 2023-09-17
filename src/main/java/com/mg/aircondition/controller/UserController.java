package com.mg.aircondition.controller;

import com.mg.aircondition.api.UsersApi;
import com.mg.aircondition.dto.GetUserResponse;
import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.dto.StatusResponse;
import com.mg.aircondition.exception.CsException;
import com.mg.aircondition.exception.Exceptions;
import com.mg.aircondition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController implements UsersApi {

    private final UserService userService;

//    private final Validator validator;

    @Override
    public ResponseEntity<StatusResponse> createUser(PostUserRequest postUserRequest) {
        if (postUserRequest.getId() != null){
            throw new CsException(Exceptions.UPDATE_USER_BAD_REQUEST_ERROR);
        }

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
    public ResponseEntity<List<GetUserResponse>> getUsers(String xToken, Integer page, Integer count) {
        List<GetUserResponse> users = userService.getUsers(xToken, page, count);
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<StatusResponse> updateUser(Integer id, String xToken, PutUserRequest putUserRequest) {
        if (!putUserRequest.getId().equals(id)){
            throw new CsException(Exceptions.UPDATE_USER_BAD_REQUEST_ERROR);
        }

        StatusResponse statusResponse = userService.updateUser(id, xToken, putUserRequest);
        return ResponseEntity.ok(statusResponse);
    }
}
