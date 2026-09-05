package com.andrewbui.identityservice.controller;

import com.andrewbui.identityservice.dto.request.PermissionRequest;
import com.andrewbui.identityservice.dto.request.RoleRequest;
import com.andrewbui.identityservice.dto.response.ApiResponse;
import com.andrewbui.identityservice.dto.response.PermissionResponse;
import com.andrewbui.identityservice.dto.response.RoleResponse;
import com.andrewbui.identityservice.service.PermissionService;
import com.andrewbui.identityservice.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    ApiResponse<String> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<String>builder()
                .message("Delete permission successful")
                .build();
    }
}
