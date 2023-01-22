package net.ikenna.employee_service.service.impl;

import lombok.AllArgsConstructor;
import net.ikenna.employee_service.dto.APIResponseDto;
import net.ikenna.employee_service.dto.DepartmentDto;
import net.ikenna.employee_service.dto.EmployeeDto;
import net.ikenna.employee_service.entity.Employee;
import net.ikenna.employee_service.repository.EmployeeRepository;
import net.ikenna.employee_service.service.APIClient;
import net.ikenna.employee_service.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
//    private final RestTemplate restTemplate;
//    private final WebClient webClient;
    private final APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),
                employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getEmail(), employeeDto.getDepartmentCode());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeDto(savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(), savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode());
    }

    @Override
    public APIResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate
//                .getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new  EmployeeDto(employee.getId(), employee.getFirstName(),
               employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
        return new APIResponseDto(employeeDto, departmentDto);
    }
}
