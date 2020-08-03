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
        employee1.setTitle("Creative");
        employee1.setTeam("");

        Employee employee2 = new Employee();
        employee2.setName("Ingrid");
        employee2.setTitle("Creative");
        employee2.setTeam("");

        Employee employee3 = new Employee();
        employee3.setName("Amaya");
        employee3.setTitle("Creative");
        employee3.setTeam("");

        Employee employee4 = new Employee();
        employee4.setName("Olga");
        employee4.setTitle("Creative");
        employee4.setTeam("");

        Employee employee5 = new Employee();
        employee5.setName("Raphael");
        employee5.setTitle("Creative");
        employee5.setTeam("");

        Employee employee6 = new Employee();
        employee6.setName("Joyce");
        employee6.setTitle("Creative");
        employee6.setTeam("");

        Employee employee7 = new Employee();
        employee7.setName("Nahom");
        employee7.setTitle("Creative");
        employee7.setTeam("");

        Employee employee8 = new Employee();
        employee8.setName("Calieb");
        employee8.setTitle("Creative");
        employee8.setTeam("");

        Department department1 = new Department();
        department1.setName("Product Management");
        department1.setLocation("NYC");
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);

        Department department2 = new Department();
        department2.setName("Design");
        department2.setLocation("DC");
        department2.addEmployee(employee3);
        department2.addEmployee(employee4);

        Department department3 = new Department();
        department3.setName("Testing");
        department3.setLocation("Chicago");
        department3.addEmployee(employee5);
        department3.addEmployee(employee6);

        Department department4 = new Department();
        department4.setName("Art");
        department4.setLocation("LA");
        department4.addEmployee(employee7);
        department4.addEmployee(employee8);

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
