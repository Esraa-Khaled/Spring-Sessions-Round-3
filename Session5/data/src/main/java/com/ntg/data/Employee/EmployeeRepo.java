package com.ntg.data.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


    @Query(value = "SELECT * FROM employee where address = :address and email =:email ", nativeQuery = true)
    Employee findEmployeeByAddressAndEmail(@Param("address") String address, @Param("email") String email);

    List<Employee> findEmployeeByEmail(String email);
}
