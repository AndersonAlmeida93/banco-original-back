package br.almeida.employeeapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.almeida.employeeapi.dto.mapper.EmployeeMapper;
import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.entity.Employee;
import br.almeida.employeeapi.utils.EmployeeUtils;

@SpringBootTest
public class EmployeeMapperTest {

	@Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void testGivenEmployeeDTOThenReturnEmployeeEntity() {
        EmployeeDTO employeeDTO = EmployeeUtils.createFakeDTO();
        Employee employee = employeeMapper.toModel(employeeDTO);

        assertEquals(employeeDTO.getFirstName(), employee.getFirstName());
        assertEquals(employeeDTO.getLastName(), employee.getLastName());
        assertEquals(employeeDTO.getEmail(), employee.getEmail());

    }

    @Test
    void testGivenEmployeeEntityThenReturnEmployeeDTO() {
        Employee employee = EmployeeUtils.createFakeEntity();
        EmployeeDTO employeeDTO = employeeMapper.toDTO(employee);

        assertEquals(employee.getFirstName(), employeeDTO.getFirstName());
        assertEquals(employee.getLastName(), employeeDTO.getLastName());
        assertEquals(employee.getEmail(), employeeDTO.getEmail());

    }
}
