package com.ntg.data.employee;

import com.ntg.data.configurations.CustomCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository implements CustomCrudOperations<Employee, Long> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAll() throws Exception{
        String sql = "select * from employee";

        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Employee> employees = new ArrayList<Employee>();
                while(rs.next()) {
                    employees.add(mapEmployeeInfo(rs));
                }
                return employees;
            }
        });
    }

    @Override
    public void save(Employee employeeInfo) {
        String sql = "INSERT INTO public.employee(address, email, first_name, last_name, phone, username)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,  employeeInfo.getAddress(), employeeInfo.getEmail(), employeeInfo.getFirstName(),
                employeeInfo.getLastName(), employeeInfo.getPhone(), employeeInfo.getUsername());
    }

    @Override
    public Employee getById(Long id) throws Exception {
        String sql = "select * from employee where id = " + id;

        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = mapEmployeeInfo(rs);
                return employee;
            }
        }).get(0);
    }

    private static Employee mapEmployeeInfo(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setUsername(rs.getString("username"));
        employee.setEmail(rs.getString("email"));
        return employee;
    }
}
