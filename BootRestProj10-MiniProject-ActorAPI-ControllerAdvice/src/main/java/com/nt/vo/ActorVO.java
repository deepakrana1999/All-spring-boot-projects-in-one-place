package com.nt.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActorVO {
       private Integer aid;
       private String aname;
       private String catagory;
       private Double fee;
       private String industry;
       private LocalDateTime dob;
}
