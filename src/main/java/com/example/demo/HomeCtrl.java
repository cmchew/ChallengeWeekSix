package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class HomeCtrl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
    @GetMapping("/listEmployee")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "listEmployee";
    }
    @GetMapping("/listDepartment")
    public String listDepartment(Model model){
        model.addAttribute("department", departmentRepository.findAll());
        return "listDepartment";
    }
    @RequestMapping("/updateEmpl/{id}")
    public String updateEmpl(@PathVariable("id") long id, Model model){
        model.addAttribute("employee", employeeRepository.findById(id));
        return "addEmployee";
    }
    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    @PostMapping("/processEmployee")
    public String processEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @RequestMapping("/detailEmployee/{id}")
    public String detailEmployee(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).get();
        model.addAttribute("employee", employee);
        return "detailEmployee";
    }

    @RequestMapping("/updateDepartment/{id}")
    public String updateDepartment(@PathVariable("id") long id, Model model){
        Department department = departmentRepository.findById().get();
        model.addAttribute("department", department);
        return "detailDepartment";
    }

//    @RequestMapping("/delete/{id}")
//    public String delCourse(@PathVariable("id") long id){
//        courseRepository.deleteById(id);
//        return "redirect:/";
//
//    }
    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/processregister")
    public String processRegistrationPage(
            @Valid @ModelAttribute("user") User user,
            BindingResult result, Model model){
        if (result.hasErrors()){
            user.clearPasswords();
            model.addAttribute("user", user);
            return "register";
        }
        else {
            model.addAttribute("user", user);
            model.addAttribute("message","New user account created");

            user.setEnabled(true);
            userRepository.save(user);

            Role role = new Role(user.getUsername(), "ROLE_USER");
            roleRepository.save(role);
        }
        return "redirect:/";
    }
    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("users", userRepository.findAll());
        return "secure";
    }

//    @RequestMapping("/")
//    public String index() {
//
//        return "index";
//    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
//    @RequestMapping("/logout")
//    public String logout() {
//        return "redirect:/login?logout=true";
//    }
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }


}
