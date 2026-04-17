package com.nt.service;



import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
    
	public String removeAllDoctorsInBatch(Iterable<Integer> ids);

}
