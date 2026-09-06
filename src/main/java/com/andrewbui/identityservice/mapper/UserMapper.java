package com.andrewbui.identityservice.mapper;

import com.andrewbui.identityservice.dto.request.UserCreationRequest;
import com.andrewbui.identityservice.dto.request.UserUpdateRequest;
import com.andrewbui.identityservice.dto.response.UserResponse;
import com.andrewbui.identityservice.entity.Role;
import com.andrewbui.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    List<UserResponse> toUserResponseList(List<User> users);
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    default String map(Role role) {
        return role == null ? null : role.getName();
    }
}
