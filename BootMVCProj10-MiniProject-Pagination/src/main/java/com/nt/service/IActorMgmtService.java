package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	
	//display all actors
    public Iterable<Actor> showAllActors(Pageable  pageable);
    
}
