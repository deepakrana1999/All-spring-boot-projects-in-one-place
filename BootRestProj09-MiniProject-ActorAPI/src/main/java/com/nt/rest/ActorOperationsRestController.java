package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.service.ActorMgmtServiceImpl;
import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsRestController {

    private final ActorMgmtServiceImpl actorService_1;
 
	@Autowired
	private IActorMgmtService actorService;

    ActorOperationsRestController(ActorMgmtServiceImpl actorService_1) {
        this.actorService_1 = actorService_1;
    }
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody ActorVO vo)
	{

		try 
		{
        //use service	
			String msg=actorService.insertActor(vo);
	     //return ResponseEntity object
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("problem in registration"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}//end method
	
	@PostMapping("/registerAll")
	public ResponseEntity<String> ragisterActorInBatch(@RequestBody List<ActorVO> listVO)
	{
		try 
		{
			String msg=actorService.insertActorsBatch(listVO);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<String>("Problem is registration::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//end method
	
	//fetch all actors operation
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllActor()
	{
		try 
		{
		Iterable<ActorVO> listVO=actorService.showAllActor();
		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<String>("Problem in retriveing:"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//end method
	
	
	@GetMapping("/find/{id}")
	 public ResponseEntity<?> fetchActorById(@PathVariable int id)
	 {
		 try
		 {
			 //use service
			 ActorVO actor=actorService.showActorById(id);
			 return new ResponseEntity<ActorVO>(actor,HttpStatus.OK);
		 }catch(Exception e)
		 {
			 return new ResponseEntity<String>("Problem in retrieving::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }//end method
	
	@GetMapping("/find/{start}/{end}")
	public ResponseEntity<?> fetchActorsByFEERange(@PathVariable int start,@PathVariable int end)
	{
		try 
		{
			//use service
			Iterable<ActorVO> listVO=actorService.showActorsByFeeRange(start, end);
			return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
			
		}catch(Exception e) 
		{
			return new ResponseEntity<String>("Problem in retrieving::"+e.getMessage(),HttpStatus.OK);
		}
	}//end method
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyActor(@RequestBody ActorVO actor)
	{
		try {
		//use service
		String msg=actorService.updateActor(actor);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Poblem in updation::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//end method
	
	@PatchMapping("/update/{id}/{hikePercentage}")
	public ResponseEntity<String> modifyActor(@PathVariable int id,@PathVariable double hikePercentage)
	{
		try {
		//use service
		String msg=actorService.updateActorFeeById(id, hikePercentage);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Poblem in updation::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//end method
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable int id)
	{
		//use service
		try 
		{
			String msg=actorService.removeActorById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<String>("Problem in deletion::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//end method
	
	//delete Actors based in fee range operation
	@DeleteMapping("/remove/{start}/{end}")
	public ResponseEntity<String> deleteActorsByFee(@PathVariable double start,@PathVariable double end)
	{
		//use server
		try {
		String msg=actorService.deleteActorsByFeeRange(start, end);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<String>("problem in deletion::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
