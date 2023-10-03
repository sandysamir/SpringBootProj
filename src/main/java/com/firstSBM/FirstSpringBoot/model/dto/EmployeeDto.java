package com.firstSBM.FirstSpringBoot.model.dto;

import com.firstSBM.FirstSpringBoot.model.entity.Employee;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id ;
    private String name;
    private Double salary ;
    public static EmployeeDto fromEntityToDto(Employee entity){
        return EmployeeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .salary(entity.getSalary())
                .build();

    }

}
