package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.ActorEntity;

public interface IActorRepository extends JpaRepository<ActorEntity,Integer> {

	@Query("from ActorEntity where fee>=:start and fee<=:end")
public Iterable<ActorEntity> findActorsByFeeRange(double start,double end);

	@Query("delete from ActorEntity where fee>=:start and fee<=:end")
	@Modifying
	@Transactional
public int removeActorsByFeeRange(double start,double end);
}
