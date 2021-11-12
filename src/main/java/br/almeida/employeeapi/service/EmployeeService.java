package br.almeida.employeeapi.service;

import java.util.List;

import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.exception.EmployeeNotFoundException;

public interface EmployeeService {

	EmployeeDTO create (EmployeeDTO employeeDTO);
	
	EmployeeDTO findById (Long id) throws EmployeeNotFoundException;
	
	List<EmployeeDTO> listAll();
	
	EmployeeDTO update(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException;
	
	void delete (Long id) throws EmployeeNotFoundException;
	
}
