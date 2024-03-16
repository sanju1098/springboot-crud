package net.javademo.springboot.controller;

import net.javademo.springboot.exception.EmailIdCannotBeNull;
import net.javademo.springboot.exception.InvalidEmailFormatException;
import net.javademo.springboot.exception.ResourceNotCreatedException;
import net.javademo.springboot.exception.ResourceNotFoundException;
import net.javademo.springboot.model.Employee;
import net.javademo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController // once we add this annotation then this class becomes Spring MVC Controller
// capable to handle http request

@RequestMapping("/api/v1/employees") // common base URL
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    // GET REST API
    @GetMapping
    public List<Employee> getAllEmployee(){
        System.out.println(employeeRepository.findAll());
        return employeeRepository.findAll();
    }


    // CREATE REST API:
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        //  Edge case
        // if email field is NULL
        if(employee.getEmailId() == null)
            throw new EmailIdCannotBeNull("Email id can't be null");

        // Validate email format using regular expression
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(employee.getEmailId());
        if (!matcher.matches())
            throw new InvalidEmailFormatException("Invalid email format");

        try{
            return employeeRepository.save(employee);
        }catch (DataAccessException ex){
            // if any other error
            throw new ResourceNotCreatedException("Unable to create employee");
        }

    }


    // GET BY ID REST API:
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee =  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee"+ id +"Not found in Records"));

        System.out.println(employee);
        return ResponseEntity.ok(employee);
    }

    // UPDATE REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee =  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee"+ id +"Not found in Records"));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return  ResponseEntity.ok(updateEmployee);
    }


    // UPDATE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee =  employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee"+ id +"Not found in Records"));

        employeeRepository.delete(employee);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
