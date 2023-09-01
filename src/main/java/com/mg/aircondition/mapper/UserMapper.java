package com.mg.aircondition.mapper;

import com.mg.aircondition.dto.PostUserRequest;
import com.mg.aircondition.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User toEntity(PostUserRequest postUserRequest);
}
