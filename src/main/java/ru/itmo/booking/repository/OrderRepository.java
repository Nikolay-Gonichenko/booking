package ru.itmo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmo.booking.model.Order;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "select count(o) from 'order' o where o.room.id = :roomId " +
            "and o.dateStart >= :dateStart and o.dateFinish <= :dateStart" +
            "and o.dateFinish >= :dateFinish and o.dateFinish >= :dateFinish", nativeQuery = true)
    boolean findBetweenDate(@Param("dateStart") Date dateStart, @Param("dateFinish") Date dateFinish, @Param("roomId") Long roomdId);
}
