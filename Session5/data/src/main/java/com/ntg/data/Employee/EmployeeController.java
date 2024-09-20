package com.ntg.data.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees() throws Exception {
       return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
    }

    @PostMapping("")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employeeInfo) throws Exception {
        try {
            employeeService.addEmployee(employeeInfo);
//            return ResponseEntity.ok("Added Successfully");
            return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
