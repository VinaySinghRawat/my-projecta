package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.Exception.ResourceNotFoundException;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//	@GetMapping("getSecreteMessage")
//	public String getSecreteMessage() {
//		return "get secrete message :sdnksbkjsjdbkjs";
//	}
	
private final EmployeeService employeeService;


   public EmployeeController(EmployeeService employeeeService)
   {
	this.employeeService=employeeeService;

   }

   @GetMapping(path = "/{employeeId}")
   public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
       Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
       return employeeDTO
               .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
               .orElseThrow(()->new ResourceNotFoundException("Employee Not Found with id "+id));
   }

   
   
   @GetMapping
   public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                               @RequestParam(required = false) String sortBy) {
       return ResponseEntity.ok(employeeService.getAllEmployees());
   }

   @PostMapping
   public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
       EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
   }


   @PutMapping(path = "/{employeeId}")
   public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
       return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
   }

   @DeleteMapping(path = "/{employeeId}")
   public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
       boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
       if (gotDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
   }

   @PatchMapping(path = "/{employeeId}")
   public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                @PathVariable Long employeeId) {
       EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
       if (employeeDTO == null) return ResponseEntity.notFound().build();
       return ResponseEntity.ok(employeeDTO);
   }

}
