package ru.itmo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmo.booking.model.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    /*@Query(*//*value = "from Room where building.id = :buildingId"*//*)*/
    @Query(value = "select * from room r where r.building_id = :buildingId",nativeQuery = true)
    List<Room> getAllByBuildingId(@Param("buildingId") Long buildingId);
}
