package net.javademo.springboot;

import net.javademo.springboot.model.Employee;
import net.javademo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Leanne");
//		employee.setLastName("Bret");
//		employee.setEmailId("leanne@gmail.com");
//
//		employeeRepository.save(employee); // to save this employee object to the database
//
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Ervin");
//		employee2.setLastName("Howell");
//		employee2.setEmailId("ervin@yahoo.com");
//
//		employeeRepository.save(employee2);

	}
}
