package com.ntg.data.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployees() throws Exception {
//        employeeRepository.getAll()
        return employeeRepo.findAll();
    }

    public Employee addEmployee(Employee employeeInfo) {
        return employeeRepo.save(employeeInfo);
//        employeeRepository.save(employeeInfo);
    }

    public Employee findByEmail(String address, String email) {
        return employeeRepo.findEmployeeByAddressAndEmail(address, email);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }


    public Employee findEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }
}
