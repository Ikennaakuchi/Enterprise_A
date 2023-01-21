package net.ikenna.department_service.service;

import net.ikenna.department_service.dtos.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto viewDepartment(Long departmentId);
    DepartmentDto getDepartmentByCode(String code);
}
