package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.repository.IActorRepository;
import com.nt.vo.ActorVO;

@Service("actorService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepository actorRepo;
	
	//Insert actor operation
	@Override
	public String insertActor(ActorVO actorVO) {
		//convert ActorVO class object to ActorEntety class obj
		ActorEntity actorEntity=new ActorEntity();
		BeanUtils.copyProperties(actorVO, actorEntity);
		actorEntity.setCreatedBy(System.getProperty("user.name"));
		//save the object
		int idVal=actorRepo.save(actorEntity).getAid();
		return "Actor Object is saved with id value:"+idVal;
	}//end method

	//Insert All Actors operation
	@Override
	public String insertActorsBatch(Iterable<ActorVO> actorsVO) {
		//convert List<ActorVO> to List<ActorEntity>objects
		List<ActorEntity> listEntities=new ArrayList<>();
		actorsVO.forEach(vo->{
			ActorEntity entity=new ActorEntity();
			BeanUtils.copyProperties(vo,entity);
			entity.setCreatedBy(System.getProperty("user.name"));
			listEntities.add(entity);
		});
		
	//saveAll objects
		Iterable<ActorEntity> savedEntities=actorRepo.saveAll(listEntities);
		List<Integer> ids=StreamSupport.stream(savedEntities.spliterator(), false).map(ActorEntity::getAid).collect(Collectors.toList());
		return ids.size()+"no. of records are saved having id vlues::"+ids;
	}//end method

	//Show All Actors operation
	@Override
	public Iterable<ActorVO> showAllActor() {
		//use service
		Iterable<ActorEntity> listEntities=actorRepo.findAll();
		//conver List of Entities to List of Vo class  objects
		List<ActorVO> listVO=new ArrayList<>();
		listEntities.forEach(entity->{
	    ActorVO vo=new ActorVO();
	    BeanUtils.copyProperties(entity,vo);
	    listVO.add(vo);
		});
		
		return listVO;
		
	}//end method

	//show Actors by id operation
	@Override
	public ActorVO showActorById(int id) {
		//Load the object
	    ActorEntity entity=actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	    //convert ActorEntity Object to ActorVO object
	    ActorVO vo=new ActorVO();
	    BeanUtils.copyProperties(entity,vo);
		return vo;
	}

	
	//show actors by Fee Range
	@Override
	public Iterable<ActorVO> showActorsByFeeRange(double startFee, double endFee) {
	//use repo
		Iterable<ActorEntity> listEntities=actorRepo.findActorsByFeeRange(startFee, endFee);
		//convert listEntities into listVO object
		List<ActorVO> listVO=new ArrayList<ActorVO>();
		listEntities.forEach(entity->{
			ActorVO vo=new ActorVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}//end method

	//update All actor data by id operations
	@Override
	public String updateActor(ActorVO vo) {
		//use repo to load the object
		ActorEntity entity=actorRepo.findById(vo.getAid()).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
		//copy vo object data to Entity Object
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdatedBy(System.getenv("user.name"));
		//update the oject
		actorRepo.save(entity);
		return vo.getAid()+"Actor details are updated";
	}//end method

	//update fee with hike percentage operation 
	@Override
	public String updateActorFeeById(int id, double hikePercentage) {
		//use repo
		ActorEntity entity=actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		entity.setFee(entity.getFee()+(entity.getFee()/100.0));
		//update the object
		actorRepo.save(entity);
		return id+"actor id fee is updated";
	}

	//delete actor operation
	@Override
	public String removeActorById(int id) {
		//load the object
		ActorEntity actor=actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid Id"));
		//delete the object
		actorRepo.deleteById(id);
		return id+"Actor has been removed";
	}//end method

	
	//delete Actors with Fee range 
	@Override
	public String deleteActorsByFeeRange(double start, double end) {
		//use repo
		int count=actorRepo.removeActorsByFeeRange(start, end);
		return count+"no. of actors are removed";
	}//end method 

}//end class
