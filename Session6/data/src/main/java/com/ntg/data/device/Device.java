package com.ntg.data.device;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ntg.data.employee.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_seq")
    @SequenceGenerator(name = "device_seq", sequenceName = "device_s")
    private Long id;

    private String name;
    private String type;
    private String model;
    private String serialNumber;

    @Lob
    @JdbcTypeCode(value = SqlTypes.LONG32VARCHAR)
    private String specs;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "emp_id")
    private Employee employee;

}
