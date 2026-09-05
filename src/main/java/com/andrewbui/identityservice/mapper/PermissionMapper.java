package com.andrewbui.identityservice.mapper;

import com.andrewbui.identityservice.dto.request.PermissionRequest;
import com.andrewbui.identityservice.dto.request.UserCreationRequest;
import com.andrewbui.identityservice.dto.request.UserUpdateRequest;
import com.andrewbui.identityservice.dto.response.PermissionResponse;
import com.andrewbui.identityservice.dto.response.UserResponse;
import com.andrewbui.identityservice.entity.Permission;
import com.andrewbui.identityservice.entity.Role;
import com.andrewbui.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
