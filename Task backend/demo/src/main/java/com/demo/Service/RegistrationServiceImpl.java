package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.DTO.RegistrationDTO;
import com.demo.Entity.Registration;
import com.demo.Mapper.RegistrationMapper;
import com.demo.RegistrationDao.RegistrationRepository;

import java.time.LocalDate;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void createRegistration(RegistrationDTO registrationDTO) {
        Registration registration = new Registration(
            registrationDTO.getName(),
            registrationDTO.getEmail(),
            LocalDate.parse(registrationDTO.getDateOfBirth())
        );
        registrationRepository.save(registration);
    }

    @Override
    public RegistrationDTO getRegistrationById(Long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
        return RegistrationMapper.mapToDTO(registration);
    }

    @Override
    public void updateRegistration(Long id, RegistrationDTO registrationDTO) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
        
        registration.setName(registrationDTO.getName());
        registration.setEmail(registrationDTO.getEmail());
        registration.setDateOfBirth(LocalDate.parse(registrationDTO.getDateOfBirth()));
        
        registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(Long id) {
        Registration registration = registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + id));
        registrationRepository.delete(registration);
    }


}
