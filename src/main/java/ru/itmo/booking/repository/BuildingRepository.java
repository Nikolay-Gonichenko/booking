package ru.itmo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itmo.booking.model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    /*@Query(*//*value = "from Building"*//*)*/
    @Query(value = "select * from building", nativeQuery = true)
    List<Building> getAll();
}
