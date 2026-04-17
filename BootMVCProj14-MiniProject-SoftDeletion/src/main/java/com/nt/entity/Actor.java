//Actor.java
package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="JPA_ACTOR_SOFT")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SQLDelete(sql="UPDATE JPA_ACTOR_SOFT SET STATUS='INACTIVE' WHERE AID=? AND UPADATE_COUNT=?")
@SQLRestriction("STATUS <> 'INACTIVE'")//for making inactive records not participate in persistence operation
public class Actor {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "ACTOR_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
   private Integer aid;
	@Column(length=20)
	@NonNull
   private String aname;
	@Column(length=30)
	@NonNull
   private String addrs;
	@NonNull
	private Double fee;
	@Column(length=20)
	@NonNull
   private String catagory;
	
	
	//METADATA columns
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDtae;//timestamp feature
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updateDate;//timestamp feature
	
	@Version
	private Integer upadateCount;//versioning feature
   
    @Column(length=20,updatable = false)
	private String createdBy;
    @Column(length=20,insertable = false)
	private String updatedBy;
	
}
