package com.myip.labs.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class UserDTO {
    @NonNull
    private String login;
    private String password;
    private String username;
    private String email;
    @NonNull
    private List<PocketDTO> pockets;
}
