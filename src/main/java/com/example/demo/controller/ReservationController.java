package com.example.demo.controller;

import com.example.demo.dto.ReservationRequestDto;
import com.example.demo.dto.ReservationResponseDto;
import com.example.demo.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ReservationResponseDto createReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        return reservationService.createReservation(reservationRequestDto.getItemId(),
                reservationRequestDto.getUserId(),
                reservationRequestDto.getStartAt(),
                reservationRequestDto.getEndAt(),
                reservationRequestDto.getStatus());
    }

    @PatchMapping("/{id}/update-status")
    public ReservationResponseDto updateReservation(@PathVariable Long id, @RequestBody Map<String, String> status) {
        return reservationService.updateReservationStatus(id, status.get("status"));
    }

    @GetMapping
    public List<ReservationResponseDto> findAll() {
        return reservationService.getReservations();
    }

    @GetMapping("/search")
    public List<ReservationResponseDto> searchAll(@RequestParam(required = false) Long userId,
                                                  @RequestParam(required = false) Long itemId) {
        return reservationService.searchAndConvertReservations(userId, itemId);
    }
}
