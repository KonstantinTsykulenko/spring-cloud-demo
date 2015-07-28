package com.smartling.reservation.app.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.smartling.reservation.app.client.InventoryClient;
import com.smartling.reservation.app.entity.Reservation;
import com.smartling.reservation.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService
{
    private InventoryClient       client;
    private ReservationRepository repository;

    @Autowired
    public ReservationService(InventoryClient client, ReservationRepository repository)
    {
        this.client = client;
        this.repository = repository;
    }

    @HystrixCommand
    public Reservation makeReservation(Reservation reservation)
    {
        client.reserve(reservation.getItemName(), reservation.getQuantity());
        return repository.save(reservation);
    }
}
