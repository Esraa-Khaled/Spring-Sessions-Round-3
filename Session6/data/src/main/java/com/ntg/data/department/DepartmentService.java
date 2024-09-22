package com.ntg.data.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDept(Department department){
          return this.departmentRepository.save(department);
    }

    public List<Department> getALL() {
        return this.departmentRepository.findAll();
    }
}
