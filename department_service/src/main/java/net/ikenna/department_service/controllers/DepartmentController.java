package net.ikenna.department_service.controllers;

import lombok.AllArgsConstructor;
import net.ikenna.department_service.dtos.DepartmentDto;
import net.ikenna.department_service.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/view_department/{departmentId}")
    public ResponseEntity<DepartmentDto> viewDepartment(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.viewDepartment(departmentId));
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(code));
    }
}
