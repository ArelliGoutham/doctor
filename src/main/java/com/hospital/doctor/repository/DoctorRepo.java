package com.hospital.doctor.repository;

import com.hospital.doctor.response.DoctorResponse;

import java.util.List;

import com.hospital.doctor.entity.Doctor;
import com.hospital.doctor.response.AllDoctorResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

    @Query(nativeQuery = true, value = "select d.name as name, d.specialization as specialization, count(p.doctor_id) as noOfPatients from doctor d join patient p on p.doctor_id = d.id where d.id = :id group by d.name")
    public DoctorResponse getDoctorDetails(int id);

    @Query(nativeQuery = true, value = "select id as id, name as name,specialization as specialization from doctor")
    public List<AllDoctorResponse> getAllDoctors();

}
