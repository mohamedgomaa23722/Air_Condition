package com.mg.aircondition.mapper;

import com.mg.aircondition.dto.GetUserResponse;
import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.dto.PutUserRequest;
import com.mg.aircondition.model.Address;
import com.mg.aircondition.model.User;
import org.mapstruct.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    GetUserResponse FromUserEntityToGetUserResponse(User user);

    List<GetUserResponse> FromUserEntityListToGetUserResponseList(List<User> users);

    User fromUserPostRequestToUser(PostUserRequest postUserRequest);

    void fromPutUserRequestToUser(@MappingTarget User user, PutUserRequest putUserRequest);

    @BeforeMapping
    default void beforeMapping(PostUserRequest postUserRequest) {

    }

    @AfterMapping
    default void afterMappingUserPostRequestToUser(@MappingTarget User user) {
        for (Address address : user.getAddresses()) {
            address.setUser(user);
        }
    }
}