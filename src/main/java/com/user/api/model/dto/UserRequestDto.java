package com.user.api.model.dto;

import com.user.api.security.validation.ValidFieldRepeat;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ValidFieldRepeat(password = "password",
        passwordRepeat = "passwordRepeat",
        message = "Passwords do not match!")
public class UserRequestDto {
    @NotNull(message = "Name can not be empty")
    @Size(min = 2, max = 20, message = "Name length should be between 2 and 20 characters")
    private String name;
    private String email;
    @Size(min = 8, message = "Password should be at least 8 characters long")
    private String password;
    @Size(min = 8)
    private String passwordRepeat;
}
