package net.javademo.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // for creating getter methods
@Setter // for creating setter methods
@NoArgsConstructor
@AllArgsConstructor

@Entity // to make this class as JPA Entity
@Table(name = "employees") // to provide table details

// instead of Getter and Setter we can use @Data
// it generated so many things like two string method, hash code method, etc

public class Employee {

    @Id // to make id as PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //provide primary key generation strategy
    private long id;

    @Column(name = "first_name",nullable = false) // to match or to create column name
    private String firstName;

    @Column(name = "last_name", nullable = false) // to match or to create column name
    private String lastName;

    @Column(name = "email_id", nullable = false) // to match or to create column name
    private String emailId;


}
