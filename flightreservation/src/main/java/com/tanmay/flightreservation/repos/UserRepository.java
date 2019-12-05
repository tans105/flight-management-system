package com.tanmay.flightreservation.repos;

import com.tanmay.flightreservation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tanmay
 * @date 05/12/19
 **/
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
