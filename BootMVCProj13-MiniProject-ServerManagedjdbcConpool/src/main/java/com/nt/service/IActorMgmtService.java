package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Actor;

public interface IActorMgmtService {
	
	//display all actors
    public Page<Actor> showAllActors(Pageable pageable);
    public String registerActor(Actor act);
    public Actor fatchActorById(int id) ;
    public String editActor(Actor act);
    public String deleteActorById(int id);
}
