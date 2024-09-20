package com.ntg.data.Employee;


import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Pattern;

import java.util.regex.Matcher;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comp_employee")
public class Employee {

    /**
     * AUTO
     * IDENTITY
     * SEQUENCE
     * TABLE
     * */


//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_table_gen")
//    @TableGenerator(name = "employee_table_gen", pkColumnName = "id", valueColumnName = "gen_id", table = "employee_id_table", allocationSize = 20, initialValue = 10)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "employee_seq", initialValue = 10, allocationSize = 2)
    private long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true, table = "emp2")
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", message="Invalid E-Mail")
    private String email;
    private String phone;
    private String address;
    @Transient
    private String fullName;

    public void setFullName(String fullName) {
        this.fullName = this.firstName +  " " +  this.lastName;
    }

    public String getFullName() {
        return this.firstName +  " " + this.lastName;
    }

    public void setEmail(String email) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

}
