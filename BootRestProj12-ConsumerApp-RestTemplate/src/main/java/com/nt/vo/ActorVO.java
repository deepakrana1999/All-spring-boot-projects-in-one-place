package com.nt.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ActorVO {
       private Integer aid;
       private String aname;
       private String catagory;
       private Double fee;
       private String industry;
       @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
       private LocalDateTime dob;
}
