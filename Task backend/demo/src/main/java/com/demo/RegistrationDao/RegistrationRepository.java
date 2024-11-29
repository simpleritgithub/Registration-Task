package com.demo.RegistrationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findByEmail(String email);
}

