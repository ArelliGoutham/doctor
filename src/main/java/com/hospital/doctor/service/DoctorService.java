package com.hospital.doctor.service;

import java.util.List;

import com.hospital.doctor.entity.Doctor;
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
        System.out.println(repo.getDoctorDetails(id));
        return repo.getDoctorDetails(id);
    }

    public List<AllDoctorResponse> getDoctors() {
        return repo.getAllDoctors();
    }

    public Doctor saveDoctor(Doctor doctor) {
        Doctor doctorIns = new Doctor();
        try {
            doctorIns = repo.save(doctor);
            return doctorIns;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // TODO: handle exception
        }
    }

    public boolean validateDoctor(int id) {
        try {
            Doctor doc = repo.getById(id);
            System.out.println(doc.getName());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
