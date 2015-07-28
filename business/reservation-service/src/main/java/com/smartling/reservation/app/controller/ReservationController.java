package com.smartling.reservation.app.controller;

import com.smartling.reservation.app.entity.Reservation;
import com.smartling.reservation.app.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("reservations")
public class ReservationController
{
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService)
    {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Reservation> makeReservation(@RequestBody Reservation reservation)
    {
        return new ResponseEntity<>(reservationService.makeReservation(reservation), HttpStatus.CREATED);
    }
}
