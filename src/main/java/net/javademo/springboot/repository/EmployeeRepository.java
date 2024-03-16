package net.javademo.springboot.repository;

import net.javademo.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
// All the CRUD methods are to be added here to interact with Database:
}
