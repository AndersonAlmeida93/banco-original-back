package br.almeida.employeeapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.exception.EmployeeNotFoundException;
import br.almeida.employeeapi.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeDTO create(@RequestBody @Valid EmployeeDTO employeeDTO) {
		return employeeService.create(employeeDTO);
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO findById(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.findById(id);
    }

    @GetMapping
    public List<EmployeeDTO> listAll() {
        return employeeService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO update(@PathVariable Long id, @RequestBody @Valid EmployeeDTO EmployeeDTO) throws EmployeeNotFoundException {
        return employeeService.update(id, EmployeeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws EmployeeNotFoundException {
    	employeeService.delete(id);
    }
}
