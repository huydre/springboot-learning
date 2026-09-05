package com.andrewbui.identityservice.mapper;

import com.andrewbui.identityservice.dto.request.PermissionRequest;
import com.andrewbui.identityservice.dto.request.RoleRequest;
import com.andrewbui.identityservice.dto.response.PermissionResponse;
import com.andrewbui.identityservice.dto.response.RoleResponse;
import com.andrewbui.identityservice.entity.Permission;
import com.andrewbui.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
