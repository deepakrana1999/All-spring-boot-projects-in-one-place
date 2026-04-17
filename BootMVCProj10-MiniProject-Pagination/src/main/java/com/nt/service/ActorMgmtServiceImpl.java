package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
   
	@Autowired
	private IActorRepository actorRepo;
	@Override
	public Iterable<Actor>showAllActors(Pageable  pageable)
	{
		return actorRepo.findAll(pageable);
	}
	
	
}
