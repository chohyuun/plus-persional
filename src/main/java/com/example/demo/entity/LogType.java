package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum LogType {
    SUCCESS("success"),
    FAILURE("failure");

    private String logType;

    LogType(String logType) {
        this.logType = logType;
    }

    @JsonCreator
    public static LogType of(String logType) {
        logType = logType.toLowerCase();

        for (LogType type : LogType.values()) {
            if (type.logType.equals(logType)) {
                return type;
            }
        }
        throw new IllegalArgumentException("해당하는 이름의 로그 타입을 찾을 수 없습니다: " + logType);
    }
}
