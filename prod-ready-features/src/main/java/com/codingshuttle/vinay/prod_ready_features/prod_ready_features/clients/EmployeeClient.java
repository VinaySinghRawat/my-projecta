package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.clients;

import java.util.List;

import com.codingshuttle.vinay.prod_ready_features.prod_ready_features.DTO.EmployeeDTO;

public interface EmployeeClient {
	 List<EmployeeDTO> getAllEmployees();

	    EmployeeDTO getEmployeeById(Long employeeId);

	    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
