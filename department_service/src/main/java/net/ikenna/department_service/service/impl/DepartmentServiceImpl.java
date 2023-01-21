package net.ikenna.department_service.service.impl;

import lombok.AllArgsConstructor;
import net.ikenna.department_service.dtos.DepartmentDto;
import net.ikenna.department_service.entities.Department;
import net.ikenna.department_service.repositories.DepartmentRepository;
import net.ikenna.department_service.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
        departmentDto.getId(), departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
       Department savedDepartment = departmentRepository.save(department);
        return new DepartmentDto(savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode());
    }

    @Override
    public DepartmentDto viewDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        return new DepartmentDto(department.getId(),
                department.getDepartmentName(), department.getDepartmentDescription(),
                department.getDepartmentCode());

    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(code);
        return new DepartmentDto(
                department.getId(), department.getDepartmentName(),
                department.getDepartmentDescription(), department.getDepartmentCode()
        );
    }
}
