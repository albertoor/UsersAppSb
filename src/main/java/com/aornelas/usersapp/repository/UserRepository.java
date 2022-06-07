package com.aornelas.usersapp.repository;

import com.aornelas.usersapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT email FROM users WHERE email = ?1", nativeQuery = true)
    Optional<String> findByEmail(String email);

    @Query(value = "SELECT phone_number FROM users WHERE phone_number = ?1", nativeQuery = true)
    Optional<String> findByPhoneNumber(String phoneNumber);
}
