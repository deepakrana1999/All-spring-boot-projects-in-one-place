package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
   
	@Autowired
	private IActorRepository actorRepo;
	@Override
	public Page<Actor>showAllActors(Pageable pageable)
	{
		return actorRepo.findAll(pageable);
	}
	@Override
	public String registerActor(Actor actor) {
		//set windows username as the created by username
		actor.setCreatedBy(System.getProperty("user.name"));
		//save object
		Integer id=actorRepo.save(actor).getAid();
		return id+": Actor registartion successful";
	}
	@Override
	public Actor fatchActorById(int id) {
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalic id"));
	}
	@Override
	public String editActor(Actor actor) {
		Optional<Actor> opt=actorRepo.findById(actor.getAid());
		if(opt.isPresent()) 
		{   
			Actor actor1=opt.get();
			actor.setUpadateCount(actor1.getUpadateCount());
			actor.setUpdatedBy(System.getProperty("user.name"));
			actorRepo.save(actor);
			return actor.getAid()+"  Actort data is modified";
		}
		return actor.getAid()+" Actor is not found";
	}
	@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) 
		{
			actorRepo.deleteById(id);
			return id+"  Actor is removed";
		}
		return id+" Actor is not found for deletion ";
	}
	
	
}
