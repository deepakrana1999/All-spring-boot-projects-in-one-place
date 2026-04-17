package com.nt.service;
import java.util.Optional;

import com.nt.entity.Doctor;
public interface IDoctorMgmtService {
	
     public String registerDoctor(Doctor doctor);
     public long showDoctersCount();
     public String registerDocterAsGroup(Iterable<Doctor>list);
     public String checkDocterAvailabilityById(int id);
     public Iterable<Doctor> findAllDoctors();
     public Iterable<Doctor> findAllDoctorsByIds(Iterable<Integer> ids);
     public Doctor showDoctorById(int id);
     public String fatchDocterById(int id);
     public Optional<Doctor> getDoctorById(int id);
     public String registerOrUpdateDoctor(Doctor doctor);//full object modification
     public String updateDoctorDetails(int id,String newQlfy,long newMobileNo);
     public String removeAllDoctors();
     public String removeAllDoctorsByIds(Iterable<Integer> ids);
     public String removeDoctorById(int id);
} 
