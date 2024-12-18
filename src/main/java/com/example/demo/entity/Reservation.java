package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Getter
@DynamicInsert
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20) default 'PENDING'")
    private Status status; // PENDING, APPROVED, CANCELED, EXPIRED

    public Reservation(Item item, User user, String status, LocalDateTime startAt, LocalDateTime endAt) {
        this.item = item;
        this.user = user;
        this.status = status != null ? Status.of(status) : null;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Reservation() {
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
}
