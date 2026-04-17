package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;
@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
   
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public String removeAllDoctorsInBatch(Iterable<Integer> ids) {
		//Load the objects based on given ids
		List<Doctor> list=doctorRepo.findAllById(ids);
		//get the avilable doctors count
		int count=list.size();
		//delete the objs in batch
		doctorRepo.deleteAllByIdInBatch(ids);
		return count+" no.of records are deleted";
	}
	
	
}
