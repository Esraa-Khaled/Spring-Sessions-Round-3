package com.ntg.data.Employee;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    private long id;
    private String username;
    @Column(name = "first_name_test")
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

}
