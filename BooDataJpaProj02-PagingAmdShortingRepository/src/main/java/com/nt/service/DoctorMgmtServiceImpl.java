package com.nt.service;

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
	
	// sort by given properties
	//findAll(sort)
	//----------------
	@Override
	public Iterable<Doctor> showAllDoctorsBySorting(boolean ascOrder, String... props) {
		//create sort object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		// use repo
		Iterable <Doctor> it=doctorRepo.findAll(sort);
		return it;
	}
     //findAll(pageable)
	//-------------------
	@Override
	public Page<Doctor> showAllDoctorsByPageNo(int pageNo, int pageSize) {
		//create the Pageable Object
		Pageable pageable=PageRequest.of(pageNo, pageSize);
		//get the requested page records
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}
     //findAll(pageable) with sort by properties
	//---------------------
	@Override
	public Page<Doctor> showAllDoctorsByPageNoAssorted(int pageNo, int pageSize, boolean ascOrder, String... props) {
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC, props);
		//create Pageble object having Sort object
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}
	@Override
	public void showAllDoctorsInpagination(int pageSize) {
		//get the count of records
		long count=doctorRepo.count();
		//get count pagesCount
		long pageCount=count/pageSize;
		if(count%pageSize!=0) 
		     pageCount++;
			//get Pageable object for every page
			for(int i=0;i<pageCount;i++) {
			//create Pageable objrct
				Pageable pageable=PageRequest.of(i, pageSize);
				//get each record
				Page <Doctor> page=doctorRepo.findAll(pageable);
				System.out.println("=====page ::"+(page.getNumber()+1)+"/"+page.getTotalPages()+" records of "+page.getTotalPages()+"======records are");
				page.forEach(System.out::println);
				System.out.println("--------------------------------------");
			}
		
		
	}
}
