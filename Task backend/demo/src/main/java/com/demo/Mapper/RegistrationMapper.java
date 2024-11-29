package com.demo.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.DTO.RegistrationDTO;
import com.demo.Entity.Registration;

public class RegistrationMapper {

    public static RegistrationDTO mapToDTO(Registration registration) {
        RegistrationDTO dto = new RegistrationDTO();
        dto.setId(registration.getId());
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setDateOfBirth(registration.getDateOfBirth().toString());
        dto.setCreatedAt(registration.getCreatedAt().toString());
        return dto;
    }
}
