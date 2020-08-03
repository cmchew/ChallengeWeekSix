package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String title;
    private String team;

//    @OneToMany(mappedBy = "employee",
//               cascade = CascadeType.ALL,
//               orphanRemoval = true)

    @ManyToMany(mappedBy = "employees",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    private Set<Department> departments;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setSales(Set<Department> sales) {
        this.departments = departments;
    }
}
