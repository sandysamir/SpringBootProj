package com.firstSBM.FirstSpringBoot.controller;

import com.firstSBM.FirstSpringBoot.model.dto.EmployeeDto;
import com.firstSBM.FirstSpringBoot.model.entity.Employee;
import com.firstSBM.FirstSpringBoot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmpService empService;
    @GetMapping("get-emp")
    public EmployeeDto getUser(@RequestParam Integer id){
        return this.empService.getUser(id);

    }
    @PostMapping("save")
    public EmployeeDto save(@RequestBody EmployeeDto employee ){
        return this.empService.save(employee);
    }

    @GetMapping("delete")
    public void delete(@RequestParam Integer id){
         this.empService.delete(id);
    }

    @GetMapping("get-all")
    public  List<Employee> getAll(){
       return this.empService.getAll();
    }


}
