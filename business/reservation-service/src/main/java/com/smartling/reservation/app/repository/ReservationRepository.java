package com.smartling.reservation.app.repository;

import com.smartling.reservation.app.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long>
{
}
