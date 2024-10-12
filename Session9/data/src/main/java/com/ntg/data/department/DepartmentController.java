package com.ntg.data.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public Department add(@RequestBody Department dept) {
        return this.departmentService.addDept(dept);
    }

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getALL());
    }

}
