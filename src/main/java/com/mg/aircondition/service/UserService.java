package com.mg.aircondition.service;

import com.mg.aircondition.dto.GetUserResponse;
import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.dto.StatusResponse;
import com.mg.aircondition.mapper.UserMapper;
import com.mg.aircondition.model.User;
import com.mg.aircondition.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public StatusResponse createUser(PostUserRequest postUserRequest) {
        //Validate user data
        //We need to insert Address
        //We need to insert User
        User user = userMapper.toEntity(postUserRequest);
        userRepository.save(user);
        return new StatusResponse()
                    .status("Successfully Added")
                .date(LocalDateTime.now().toString())
                .message("Successfully Added");
    }

    public StatusResponse deleteUser(Integer id, String xToken) {
        return null;
    }

    public GetUserResponse getUser(Integer id, String xToken) {
        return null;
    }

    public List<GetUserResponse> getUsers(String xToken) {
        return null;
    }

    public StatusResponse updateUser(Integer id, String xToken, PutUserRequest putUserRequest) {
        return null;
    }
}
