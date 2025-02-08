package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

	
	private Long id;
	private String name;
	private String email;
private Integer age;
	
	 private String role; //ADMIN, USER
	  
	  
	 private Double salary;
	
	  
	private LocalDate dateOfJoining;
	  
	private Boolean  isActive;

}
