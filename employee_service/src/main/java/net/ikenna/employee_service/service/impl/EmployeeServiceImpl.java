package net.ikenna.employee_service.service.impl;

import lombok.AllArgsConstructor;
import net.ikenna.employee_service.dto.EmployeeDto;
import net.ikenna.employee_service.entity.Employee;
import net.ikenna.employee_service.repository.EmployeeRepository;
import net.ikenna.employee_service.service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),
                employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDto(savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(), savedEmployee.getEmail());
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).get();
       return new EmployeeDto(employee.getId(), employee.getFirstName(),
               employee.getLastName(), employee.getEmail());
    }
}
