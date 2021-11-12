package br.almeida.employeeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.almeida.employeeapi.dto.mapper.EmployeeMapper;
import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.entity.Employee;
import br.almeida.employeeapi.exception.EmployeeNotFoundException;
import br.almeida.employeeapi.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
    private EmployeeRepository employeeRepository;

	@Autowired
    private EmployeeMapper employeeMapper;

	@Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
		Employee employee = employeeMapper.toModel(employeeDTO);
        Employee save = employeeRepository.save(employee);

        return employeeMapper.toDTO(save);
    }

	@Override
    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return employeeMapper.toDTO(employee);
    }

	@Override
    public List<EmployeeDTO> listAll() {
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

	@Override
    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
		employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

		Employee employee = employeeMapper.toModel(employeeDTO);
        Employee save = employeeRepository.save(employee);

        return employeeMapper.toDTO(save);
    }

	@Override
    public void delete(Long id) throws EmployeeNotFoundException {
		employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

		employeeRepository.deleteById(id);
    }

}
