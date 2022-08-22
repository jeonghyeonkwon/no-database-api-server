package com.jeonghyeon.nodatabaseapi.dto;

import lombok.Getter;

@Getter
public class UserEntity {
    private Long id;
    private String uuid;
    private String username;
    private String password;

    public UserEntity(Long id, String uuid, String userId, String password) {
        this.id = id;
        this.uuid = uuid;
        this.username = userId;
        this.password = password;
    }
}
