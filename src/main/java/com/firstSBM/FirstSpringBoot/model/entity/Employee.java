package com.firstSBM.FirstSpringBoot.model.entity;

import com.firstSBM.FirstSpringBoot.model.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "employees")
@Data
@Entity
@Builder

//@NoArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "emp_name")
    private String name;
    private Double salary ;

    public Employee() {}

    public Employee(Integer id ,String name , Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public static Employee toEntity(EmployeeDto dto) {
        return  Employee.builder().
                id(dto.getId())
                .name(dto.getName())
                .salary(dto.getSalary())
                .build();
    }

}
