package br.almeida.employeeapi.dto.mapper;

import br.almeida.employeeapi.dto.request.EmployeeDTO;
import br.almeida.employeeapi.dto.request.EmployeeDTO.EmployeeDTOBuilder;
import br.almeida.employeeapi.entity.Employee;
import br.almeida.employeeapi.entity.Employee.EmployeeBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-12T07:12:32-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1200.v20200916-0645, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toModel(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeBuilder employee = Employee.builder();

        employee.email( dto.getEmail() );
        employee.firstName( dto.getFirstName() );
        employee.id( dto.getId() );
        employee.lastName( dto.getLastName() );

        return employee.build();
    }

    @Override
    public EmployeeDTO toDTO(Employee dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeDTOBuilder employeeDTO = EmployeeDTO.builder();

        employeeDTO.email( dto.getEmail() );
        employeeDTO.firstName( dto.getFirstName() );
        employeeDTO.id( dto.getId() );
        employeeDTO.lastName( dto.getLastName() );

        return employeeDTO.build();
    }
}
