package com.ntg.data.employee;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EntityManager entityManager;

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
//            return ResponseEntity.ok("Added Successfully");
            return new ResponseEntity<>(employeeService.addEmployee(employeeInfo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable Long id) {
        try {
            Employee employee =  employeeService.findEmployeeById(id);
            entityManager.detach(employee);
            employee.setPhone("Updated value-Test");
            entityManager.merge(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
