package com.ntg.data.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepo employeeRepo;


    @Cacheable(value = "employee", key = "{#root.methodName}")
    public List<Employee> getAllEmployees() throws Exception {
//        employeeRepository.getAll()
        return employeeRepo.findAll();
    }

    @CacheEvict(value = "employee", allEntries = true)
    public Employee addEmployee(Employee employeeInfo) throws Exception {
        Thread.sleep(2000);
        return employeeRepo.save(employeeInfo);
//        employeeRepository.save(employeeInfo);
    }

    public Employee findByEmail(String address, String email) {
        return employeeRepo.findEmployeeByAddressAndEmail(address, email);
    }

    @CacheEvict(value = "employee", allEntries = true)
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }


    @Cacheable(value = "employee", key = "{#root.methodName, #p0}")
    public Employee findEmployeeById(Long id) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Inside findEmployeeById");
        return employeeRepo.findById(id).orElseThrow();
    }
}
