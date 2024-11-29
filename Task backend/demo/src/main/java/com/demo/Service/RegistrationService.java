package com.demo.Service;

import com.demo.DTO.RegistrationDTO;

public interface RegistrationService {
    void createRegistration(RegistrationDTO registrationDTO);
    RegistrationDTO getRegistrationById(Long id);
    void updateRegistration(Long id, RegistrationDTO registrationDTO);
    void deleteRegistration(Long id);
}
