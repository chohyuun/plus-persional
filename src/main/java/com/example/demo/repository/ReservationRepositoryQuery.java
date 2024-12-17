package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.ReservationCond;

import java.util.List;

public interface ReservationRepositoryQuery {
    List<Reservation> search(ReservationCond cond);
}
