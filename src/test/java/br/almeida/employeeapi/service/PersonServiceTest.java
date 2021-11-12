package br.almeida.employeeapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.almeida.employeeapi.dto.mapper.EmployeeMapper;
import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.entity.Employee;
import br.almeida.employeeapi.repository.EmployeeRepository;
import br.almeida.employeeapi.utils.EmployeeUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	
	@Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        EmployeeDTO employeeDTO = EmployeeUtils.createFakeDTO();
        Employee employee = EmployeeUtils.createFakeEntity();

        when(employeeMapper.toModel(employeeDTO)).thenReturn(employee);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDTO dto = employeeServiceImpl.create(employeeDTO);

        assertEquals(employee, dto);
    }

}
