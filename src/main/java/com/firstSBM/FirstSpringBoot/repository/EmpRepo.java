package com.firstSBM.FirstSpringBoot.repository;

import com.firstSBM.FirstSpringBoot.model.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
// integer ely beside l employee da datatype of the id ;
public interface EmpRepo extends JpaRepository<Employee, Integer> {
}
