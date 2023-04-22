package ru.itmo.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itmo.booking.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.isuId = :isuId and u.password = :password")
    Optional<User> getByIsuIdAndPassword(@Param("isuId") Integer isuId, @Param("password") String password);

    @Query(value = "select u from User u where u.token = :token")
    Optional<User> getByToken(@Param("token") String token);
}
