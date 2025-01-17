package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import java.time.LocalDate;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {

	
	private Long id;
	  @NotBlank(message = "Name of the employee cannot be blank")
	    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3, 10]")
	private String name;
	  @NotBlank(message = "Email of the employee cannot be blank")
	    @Email(message = "Email should be a valid email")
	private String email;
	  @NotNull(message = "Age of the employee cannot be blank")
	    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
	    @Min(value = 18, message = "Age of Employee cannot be less than 18")
	private Integer age;
	
	  @NotBlank(message = "role of employee cannot be  blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be USER or ADMIN")
	  @EmployeeRoleValidation
    private String role; //ADMIN, USER
	  
	  
	  @NotNull(message = "Salary of Employee should be not null")
	    @Positive(message = "Salary of Employee should be positive")
	    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
	    @DecimalMax(value = "100000.99")
	    @DecimalMin(value = "100.50")
	    private Double salary;
	
	  
	  @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
	private LocalDate dateOfJoining;
	  
	  @AssertTrue(message = "Employee should be active")
	    @JsonProperty("isActive")
	private Boolean  isActive;

}
