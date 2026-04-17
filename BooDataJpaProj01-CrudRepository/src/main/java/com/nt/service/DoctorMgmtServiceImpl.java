//service impl class
package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.exception.DoctorNotFountException;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	@Autowired
	private IDoctorRepository doctorRepo;// Inject the dynamically InMemory Proxy class obj
    
	//save() method
	//---------------------
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("Repository obj class name(InMemory Proxy class name)::" + doctorRepo.getClass().getName());
		System.out.println("List of implemented interfaces::" + Arrays.toString(doctorRepo.getClass().getInterfaces()));
		System.out.println("List of methods::" + Arrays.toString(doctorRepo.getClass().getDeclaredMethods()));
		// save the object (insert the record)
		// save methord retun Docter object
		// get the generated id value
		int idVal = doctorRepo.save(doctor).getDid();
		return "Doctor obj is saved with id Value::" + idVal;
	}

	// count() value of rows in db table
	//------------------------------------
	@Override
	public long showDoctersCount() {
		long count = doctorRepo.count();
		return count;
	}
     
	// saveAll()Method list of object into db table
	//----------------------------------------------
	//type casting is not good programming
	 // @Override 
		/*public String registerDocterAsGroup(Iterable<Doctor> list) { 
		//save objects 
		Iterable<Doctor> savedList=doctorRepo.saveAll(list);
		 //get saved objs count 
		 //typecast 
		 List<Doctor> savedList1=(List<Doctor>)savedList;
		 int count=savedList1.size();
		 //get only id valus from the saved list
		 List<Integer>ids=new ArrayList<>();
		 savedList1.forEach(doc->{ids.add(doc.getDid());}); 
		 return count+" no of doctors are save with id values"+ids; 
		 }*/
	 

	
	  @Override public String registerDocterAsGroup(Iterable<Doctor> list) { 
		  //save objects
	  Iterable<Doctor> savedList=doctorRepo.saveAll(list); 
	 List<Integer> ids=StreamSupport.stream(savedList.spliterator(),false).map(Doctor::getDid).collect(Collectors.toList());
	 return ids.size()+" no of docters are saved with id values"+ids;
	  }
	  
   //existById() method
  //---------------------
	@Override
	public String checkDocterAvailabilityById(int id) {
		boolean flag=doctorRepo.existsById(id);
		return flag?id+" Doctor Available":id+" Doctor Not Available";
	}
	
    //findAll()method
	//------------------
	@Override
	public Iterable<Doctor> findAllDoctors() {
		return doctorRepo.findAll();
	}
    
	//findAllByIds
	//-------------------
	@Override
	public Iterable<Doctor> findAllDoctorsByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}
	
	
     //findById
	//-----------------
	//approach - 1
	//---------------
		/*	@Override
					public Doctor showDoctorById(int id) {
						Optional<Doctor> opt=doctorRepo.findById(id);
						if(opt.isPresent()) 
						{
							//get the object
							Doctor doc=opt.get();
							return doc; 
						}
					    throw new IllegalArgumentException("Invalid Doctor Id");
					}
				*/
	//approach - 2
    //---------------
	/*@Override
	 *findById returns Optional object
	public Doctor showDoctorById(int id) 
	{
		return doctorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
	}*/
	//if real doctor is not available default Doctor will come
	public Doctor showDoctorById(int id) 
	{
		return doctorRepo.findById(id).orElse(new Doctor(1111,"abc","MBBs",9999L,888888L,"Duty-Doctor")) ;
	}
	
	//approach - 3
	//---------------
	//@Override
	/*public Doctor showDoctorById(int id) 
	{
		return doctorRepo.findById(id).orElseThrow(()->new DoctorNotFountException());
	}*/
    //approach - 4
	//-------------
	@Override
	public String fatchDocterById(int id) {
		//Load obj
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) 
		{
			Doctor doc=opt.get();
			return id+" doctor id details are"+doc;
		}else {
         return id+" Doctor is not found";
		}
	}
	//approach - 5
	//-------------

	@Override
	public Optional<Doctor> getDoctorById(int id) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isEmpty())
		return Optional.empty();
		else
			return opt;
	}
   //save() methord for save or update operation
	//------------------------------------------
	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {
		doctorRepo.save(doctor);
		return "Doctor is save / update";
	}
	
    //update values to spesify column
	//----------------------------------
	@Override
	public String updateDoctorDetails(int id, String newQlfy, long newMobileNo) {
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) 
		{
		Doctor doc=opt.get();
		doc.setQlfy(newQlfy);doc.setMobileNo(newMobileNo);
		doctorRepo.save(doc);
		return "Doctor details  are updated";
		}
		return "Doctor is not found for updation";
	}

	//deleteAll() method
	//-----------------------
	@Override
	public String removeAllDoctors() {
		//get count of Doctor count
		Long count=doctorRepo.count();
		//delete all thr records
		doctorRepo.deleteAll();
		return count+" no.of Doctors are dleted";
	}
    //deteteAllById()
	//-------------------------
	@Override
	public String removeAllDoctorsByIds(Iterable<Integer> ids) {
	//geting Doctors by ids
		Iterable<Doctor> list=doctorRepo.findAllById(ids);
		long count=StreamSupport.stream(list.spliterator(), false).count();
		doctorRepo.deleteAllById(ids);
		return count+" no.of Doctors are deleted";
	}

	@Override
	public String removeDoctorById(int id) {
	//Load the object
		Optional<Doctor> opt=doctorRepo.findById(id);
		if(opt.isPresent()) 
		{
			doctorRepo.deleteById(id);
			return id+" id Doctor is deleted";
		}
		return id+" id Doctor not found for Deletion";
	}
}
