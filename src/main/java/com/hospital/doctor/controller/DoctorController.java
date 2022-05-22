package com.hospital.doctor.controller;

import java.util.List;

import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.response.AllDoctorResponse;
import com.hospital.doctor.response.DoctorResponse;
import com.hospital.doctor.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService service;

    private DoctorResponse DoctorResponse;

    private List<AllDoctorResponse> AllDoctorResponse;

    @GetMapping(value = "/doctor/{id}")
    public ResponseEntity<DoctorResponse> getDoctorDetails(@PathVariable int id) {
        DoctorResponse = service.getDoctor(id);
        if (DoctorResponse != null) {
            return new ResponseEntity<DoctorResponse>(DoctorResponse,
                    HttpStatus.OK);
        } else if (DoctorResponse == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/doctors")
    public ResponseEntity<List<AllDoctorResponse>> getMethodName() {
        AllDoctorResponse = service.getDoctors();
        ResponseEntity<List<AllDoctorResponse>> responseEntity = new ResponseEntity<List<AllDoctorResponse>>(
                AllDoctorResponse,
                HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(value = "/doctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor entity) {
        Doctor doctor = new Doctor();
        doctor = service.saveDoctor(entity);
        if (doctor != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/doctor/{id}")
    public ResponseEntity<Doctor> validateDoctor(@PathVariable int id) {
        boolean status = service.validateDoctor(id);
        if (status) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
