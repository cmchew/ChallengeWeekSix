package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void run(String...args){
        User user = new User("mc", "mc@domain.com", "mc", "MC", "Raptors", true);
        Role userRole = new Role("mc", "ROLE_USER");

        userRepository.save(user);
        roleRepository.save(userRole);

        User admin = new User("admin", "admin@domain.com", "admin", "Admin", "Person", true);
        Role adminRole1 = new Role ("admin", "ROLE_ADMIN");
        Role adminRole2 = new Role("admin", "ROLE_USER");

        userRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

        Employee employee1 = new Employee();
        employee1.setName("Cassie");
        employee1.setTitle("");
        employee1.setTeam("");

        Employee employee2 = new Employee();
        employee2.setName("Ingrid");
        employee2.setTitle("");
        employee2.setTeam("");

        Employee employee3 = new Employee();
        employee3.setName("Amaya");
        employee3.setTitle("");
        employee3.setTeam("");

        Employee employee4 = new Employee();
        employee4.setName("Olga");
        employee4.setTitle("");
        employee4.setTeam("");

        Employee employee5 = new Employee();
        employee5.setName("Raphael");
        employee5.setTitle("");
        employee5.setTeam("");

        Employee employee6 = new Employee();
        employee6.setName("Joyce");
        employee6.setTitle("");
        employee6.setTeam("");

        Employee employee7 = new Employee();
        employee7.setName("Nahom");
        employee7.setTitle("");
        employee7.setTeam("");

        Employee employee8 = new Employee();
        employee8.setName("Calieb");
        employee8.setTitle("");
        employee8.setTeam("");

        Department department1 = new Department();
        department1.setName("hr");
//        department1.setPrice(299.00);
        department1.addempl(employee1);
        department1.addempl(employee2);

        Department department2 = new Department();
        department2.setName("it");
//        department2.setPrice(19.00);
        department2.addempl(employee3);
        department2.addempl(employee4);

        Department department3 = new Department();
        department3.setName("sales");
//        department3.setPrice(19.00);
        department3.addempl(employee5);
        department3.addempl(employee6);

        Department department4 = new Department();
        department4.setName("sales");
//        department4.setPrice(19.00);
        department4.addempl(employee7);
        department4.addempl(employee8);

        employeeRepository.save(employee8);
        employeeRepository.save(employee7);
        employeeRepository.save(employee6);
        employeeRepository.save(employee5);
        employeeRepository.save(employee4);
        employeeRepository.save(employee3);
        employeeRepository.save(employee2);
        employeeRepository.save(employee1);

        departmentRepository.save(department4);
        departmentRepository.save(department3);
        departmentRepository.save(department2);
        departmentRepository.save(department2);




    }
}
