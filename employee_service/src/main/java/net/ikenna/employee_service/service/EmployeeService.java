package net.ikenna.employee_service.service;

import net.ikenna.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long employeeId);
}
