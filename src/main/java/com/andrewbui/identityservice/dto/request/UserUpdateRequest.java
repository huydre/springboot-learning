package com.andrewbui.identityservice.dto.request;

import com.andrewbui.identityservice.validator.DobConstaint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;
    String firstName;
    String lastName;

    @DobConstaint(min = 18, message = "INVALID_DOB")
    LocalDate dob;
    Set<String> roles;
}
