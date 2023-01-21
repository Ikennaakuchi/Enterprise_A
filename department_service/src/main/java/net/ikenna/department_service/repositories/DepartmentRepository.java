package net.ikenna.department_service.repositories;

import net.ikenna.department_service.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCode(String code);
}
