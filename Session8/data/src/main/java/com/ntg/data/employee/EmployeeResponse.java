package com.ntg.data.employee;


import com.ntg.data.department.Department;
import com.ntg.data.device.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private Device device;
    private Department department;


}
