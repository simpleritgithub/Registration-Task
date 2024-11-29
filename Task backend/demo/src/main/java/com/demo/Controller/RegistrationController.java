package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.DTO.RegistrationDTO;
import com.demo.Service.RegistrationService;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> createRegistration(@RequestBody RegistrationDTO registrationDTO) {
        try {
            registrationService.createRegistration(registrationDTO);
            return new ResponseEntity<>("Registration created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistrationById(@PathVariable Long id) {
        try {
            RegistrationDTO registrationDTO = registrationService.getRegistrationById(id);
            return new ResponseEntity<>(registrationDTO, HttpStatus.OK);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRegistration(@PathVariable Long id, @RequestBody RegistrationDTO registrationDTO) {
        try {
            registrationService.updateRegistration(id, registrationDTO);
            return new ResponseEntity<>("Registration updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegistration(@PathVariable Long id) {
        try {
            registrationService.deleteRegistration(id);
            return new ResponseEntity<>("Registration deleted successfully", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return handleException(e);
        }
    }

    
    private ResponseEntity<String> handleException(Exception e) {
      
        String errorMessage = "An error occurred: " + e.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
