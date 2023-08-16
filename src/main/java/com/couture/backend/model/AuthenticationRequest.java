package com.couture.backend.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    @NotNull
    private String login;

    @NotNull
    private String password;

}
