package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL("normal"),
    BLOCKED("blocked");

    private String status;

    UserStatus(String status) {
        this.status = status;
    }

    @JsonCreator
    public static UserStatus of(String status) {
        status = status.toLowerCase();
        
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.status.equals(status)) {
                return userStatus;
            }
        }
        throw new IllegalArgumentException("해당하는 이름의 상태를 찾을 수 없습니다: " + status);
    }
}
