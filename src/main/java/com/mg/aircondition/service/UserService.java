package com.mg.aircondition.service;

import com.mg.aircondition.aspect.annotations.UserExist;
import com.mg.aircondition.aspect.annotations.UserPhoneNumberExist;
import com.mg.aircondition.dto.GetUserResponse;
import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.dto.StatusResponse;
import com.mg.aircondition.exception.CsException;
import com.mg.aircondition.exception.Exceptions;
import com.mg.aircondition.mapper.UserMapper;
import com.mg.aircondition.model.Address;
import com.mg.aircondition.model.User;
import com.mg.aircondition.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @UserPhoneNumberExist
    public StatusResponse createUser(PostUserRequest postUserRequest) {
        User user = userMapper.fromUserPostRequestToUser(postUserRequest);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new CsException(Exceptions.POST_USER_INTERNAL_ERROR);
        }

        return new StatusResponse()
                .status("Successfully Created")
                .date(LocalDateTime.now().toString())
                .message("Successfully Created");
    }

    @UserExist
    public StatusResponse deleteUser(Integer id, String xToken) {
        userRepository.deleteById(id);
        return new StatusResponse()
                .status("Successfully Deleted")
                .date(LocalDateTime.now().toString())
                .message("Successfully Deleted");
    }

    @UserExist
    public GetUserResponse getUser(Integer id, String xToken) {
        User userEntity = userRepository.findById(id).get();
        return userMapper.FromUserEntityToGetUserResponse(userEntity);
    }

    public List<GetUserResponse> getUsers(String xToken, Integer page, Integer count) {
        Pageable pageRequest = PageRequest.of(page, count);
        Page<User> users = userRepository.findAll(pageRequest);
        return userMapper.FromUserEntityListToGetUserResponseList(users.toList());
    }

    @UserExist
    public StatusResponse updateUser(Integer id, String xToken, PutUserRequest putUserRequest) {
        User userEntity = userRepository.findById(id).get();
        userMapper.fromPutUserRequestToUser(userEntity, putUserRequest);

        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            throw new CsException(Exceptions.POST_USER_INTERNAL_ERROR);
        }

        return new StatusResponse()
                .status("Successfully Updated")
                .date(LocalDateTime.now().toString())
                .message("Successfully Updated");
    }


}
