package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {

	public Iterable<Doctor> showAllDoctorsBySorting(boolean ascOrder,String ...props);
	public Page<Doctor> showAllDoctorsByPageNo(int pageNo,int pageSize);
	public Page<Doctor> showAllDoctorsByPageNoAssorted(int pageNo,int pageSize,boolean ascOrder,String...props);
	public void showAllDoctorsInpagination(int pageSize);
}
