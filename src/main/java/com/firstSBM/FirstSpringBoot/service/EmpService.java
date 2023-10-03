package com.firstSBM.FirstSpringBoot.service;

import com.firstSBM.FirstSpringBoot.model.dto.EmployeeDto;
import com.firstSBM.FirstSpringBoot.model.entity.Employee;
import com.firstSBM.FirstSpringBoot.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public EmployeeDto getUser(Integer id){
        Optional<Employee> emp = this.empRepo.findById(id);
        return emp.map(EmployeeDto::fromEntityToDto).orElse(null);
    }
    public EmployeeDto save( EmployeeDto employee ){
        return EmployeeDto.fromEntityToDto(this.empRepo.save(Employee.toEntity(employee)));
    }
    public void delete(Integer id){
        this.empRepo.deleteById(id);
    }
    public List<Employee> getAll(){
        return this.empRepo.findAll();

    }
}
