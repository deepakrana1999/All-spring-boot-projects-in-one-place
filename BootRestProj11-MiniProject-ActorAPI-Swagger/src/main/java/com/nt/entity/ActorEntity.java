package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="REST_JPA_ACTOR")
public class ActorEntity {
	   @Id
	   @SequenceGenerator(name="gen1",sequenceName="aid_seq",initialValue=1,allocationSize=1)
	   @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
       private Integer aid;
	   @NonNull
       private String aname;
	   @NonNull
       private String catagory;
	   @NonNull
       private Double fee;
	   @NonNull 
       private String industry;
	   @NonNull
	   private LocalDateTime dob;
	   
	   
	   
	   @Version
	   private Integer updateCount;
	   @CreationTimestamp
	   @Column(updatable=false)
	   private LocalDateTime creationTime;
	   @UpdateTimestamp
	   @Column(insertable=false)
	   private LocalDateTime lastupdateTime;
	   @Column(length=30)
	   private String createdBy;
	   @Column(length=30)
	   private String updatedBy;
	   @Column(length=30)
	   private String Status="enable";
}
