package com.ntg.data.employee;

import com.ntg.data.exceptions.PreventSaveException;
import com.ntg.data.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepo employeeRepo;


//    @Cacheable(value = "employee", key = "{#root.methodName}")
    public List<Employee> getAllEmployees() throws Exception {
        System.out.println("Inside call getAllEmployees service");
//        throw new Exception("Invalid Data")
        return employeeRepo.findAll();
    }

//    @CacheEvict(value = "employee", allEntries = true)
    public Employee addEmployee(Employee employeeInfo) throws Exception {
        if (employeeInfo != null) {
            if (employeeInfo.getPhone() == null || employeeInfo.getPhone().isEmpty()) {
                throw new Exception("");
            } else {
                return employeeRepo.save(employeeInfo);
            }
        }
        return null;
    }

    public Employee findByEmail(String address, String email) {
        return employeeRepo.findEmployeeByAddressAndEmail(address, email);
    }

    @CacheEvict(value = "employee", allEntries = true)
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }


//    @Cacheable(value = "employee", key = "{#root.methodName, #p0}")
    public Employee findEmployeeById(Long id) throws Exception {
//        Optional<Employee> employee = employeeRepo.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new RecordNotFoundException("Employee with id: " + id + " not exist");
//        }
//
        return employeeRepo.findById(id).orElseThrow
                (() -> new RecordNotFoundException("Employee with id: " + id + " not exist"));
    }
}
