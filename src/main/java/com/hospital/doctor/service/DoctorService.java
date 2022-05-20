package com.hospital.doctor.service;

import java.util.List;

import com.hospital.doctor.repository.DoctorRepo;
import com.hospital.doctor.response.AllDoctorResponse;
import com.hospital.doctor.response.DoctorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo repo;

    public DoctorResponse getDoctor(int id) {
        return repo.getDoctorDetails(id);
    }

    public List<AllDoctorResponse> getDoctors() {
        return repo.getAllDoctors();
    }

}
