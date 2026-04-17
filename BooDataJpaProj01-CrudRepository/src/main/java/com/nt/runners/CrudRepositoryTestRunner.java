package com.nt.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService docService;

	@Override
	public void run(String... args) throws Exception {

		/* try { 
		  //prepare Doctor object 
		  Doctor doc=new Doctor("kamal","A=MD",8041636L,943662L,"ortho");
		  String msg=docService.registerDoctor(doc); System.out.println(msg); }
		 catch(Exception e) 
		   {  
		  e.printStackTrace(); 
		   }*/
			 

		/*try { 
		System.out.println("Docter count::"+docService.showDoctersCount()); 
		}
		catch(Exception e) 
		{
		  e.printStackTrace();
		 }*/

		
		/* try { 
		  Doctor doc1=new Doctor("suresh","MD",93416361L,9416624L,"cardio");
		     Doctor doc2=new Doctor("mahesh","AD",93416362L,9416625L,"physio");
		     Doctor doc3=new Doctor("karan","AD",93416363L,9416627L,"nuero");
		     Doctor doc4=new Doctor("mahi","MBBS",93416363L,9416627L,"nuero");
		     Doctor doc5=new Doctor("sahi","AD",93416363L,9416627L,"ortho");
		   //java 9 feature giving immutable collection
		     List<Doctor> list=List.of(doc1,doc2,doc3,doc4,doc5);
		     
		 String resultMsg=docService.registerDocterAsGroup(list);
		 System.out.println(resultMsg); } 
		 catch(Exception e) 
		 { e.printStackTrace(); }*/
		 

		/*try 
		{
			String msg=docService.checkDocterAvailabilityById(101);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}*/

		/*	try 
			{
			Iterable<Doctor> list=docService.findAllDoctors();
			list.forEach(doc->{
				System.out.println(doc);
			});
			System.out.println("----------------------------------");
			list.forEach(doc->System.out.println(doc));
			System.out.println("----------------------------------");
			list.forEach(System.out::println);
			System.out.println("----------------------------------");
			StreamSupport.stream(list.spliterator(),false).forEach(System.out::println);
			long count=StreamSupport.stream(list.spliterator(),false).count();
			System.out.println("----------------------------------");
			System.out.println("No.of records::"+count);
			System.out.println("----------------------------------");
			List<String> specialatiesList=StreamSupport.stream(list.spliterator(), false).map(Doctor::getSpecialization).collect(Collectors.toList());
			System.out.println(specialatiesList);
			System.out.println("----------------------------------");
			for(Doctor doc:list) {
				System.out.println(doc);
				}
			System.out.println("----------------------------------");
			 List<Doctor> list1=StreamSupport.stream(list.spliterator(), false).toList();
			 for(int i=0;i<count;++i) {
				 System.out.println(list1.get(i));
			 }
			}
			
			catch(Exception e) 
			{
				e.printStackTrace();
			}*/
		/*   try 
		  { 
			  //by using new key word
			  List<Integer> ids=new ArrayList<>();
			  //here we adding null but we can not get NullPoininerException because List id mutable
			  ids.add(101);ids.add(102);ids.add(103);ids.add(null);
			  Iterable<Doctor>  it=docService.findAllDoctorsByIds(ids);
			  
				 //by using Arrays.asList()
				//here we adding null but we can not get NullPoininerException because List id mutable
				   List<Integer> ids=Arrays.asList(101,102,103,null) ; 
				   Iterable<Doctor>  it=docService.findAllDoctorsByIds(ids);
				   
			  //here we can not Add null List.of()method gives immutable List
			  Iterable<Doctor>  it=docService.findAllDoctorsByIds(List.of(101,102,103,901));
			 long count=StreamSupport.stream(it.spliterator(), false).count();
			 System.out.println(count+" no.of doctors are found with the given ids");
			 it.forEach(doc->System.out.println(doc));
		  }
		  catch(Exception e) 
		  {
			  e.printStackTrace();
		  }*/
		
		/*try 
			{
				Doctor doc=docService.showDoctorById(52);
				System.out.println("Docter info is::"+doc);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		/*	try 
			{
				String str= docService.fatchDocterById(52);
		    System.out.println(str);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		/*	try 
			{
				Optional<Doctor> opt=docService.getDoctorById(252);
				if(opt.isEmpty()){
					System.out.println("Doctor not fpund");
				}
				else {
					System.out.println("Doctor found::"+opt.get());
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}*/
		
		/*try 
		{
			Doctor doc=new Doctor(152,"suresh","Md",899999L,7777777L,"cardio");
			String msg=docService.registerOrUpdateDoctor(doc);
			System.out.println(msg);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}*/
		
		/*try 
		{
		String msg=	docService.updateDoctorDetails(52, "MD-ERC London", 978628763L);
		System.out.println(msg);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			}*/
		
		/*try 
		{
			String msg=docService.removeAllDoctors();
			System.out.println(msg);
		}
		catch(Exception e){
			e.printStackTrace();}*/
		
		/*try 
		{
			String msg=docService.removeAllDoctorsByIds(List.of(115, 116, 117,303,304));
			System.out.println(msg);
		}
		catch(Exception e) 
		{e.printStackTrace();}*/
		
		try 
		{
		String msg=docService.removeDoctorById(118);
		System.out.println(msg);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}// run

}// class
