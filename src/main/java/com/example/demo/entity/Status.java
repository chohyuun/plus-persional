package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Status {
    PENDING("pending"),
    APPROVED("approved"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    @JsonCreator
    public static Status of(String status) {
        status = status.toLowerCase();

        for (Status s : Status.values()) {
            System.out.println(status + " " + s.getStatus());

            if (s.status.equals(status)) {

                return s;
            }
        }
        throw new IllegalArgumentException("해당하는 이름의 상태를 찾을 수 없습니다: " + status);
    }

    @JsonCreator
    public static Status change(Status oldStatus, Status newStatus) {
        if (oldStatus.equals(Status.PENDING)) {
            if (newStatus.equals(Status.APPROVED) || newStatus.equals(Status.EXPIRED)) {
                return newStatus;
            }
        }
        if (oldStatus.equals(Status.EXPIRED)) {
            if (!newStatus.equals(Status.CANCELED)) {
                return newStatus;
            } else {
                throw new IllegalArgumentException("EXPIRED 상태인 예약은 취소할 수 없습니다.");
            }
        }
        throw new IllegalArgumentException(oldStatus.getStatus() + " 상태만 " + newStatus.getStatus() + "로 변경 가능합니다.");
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}
