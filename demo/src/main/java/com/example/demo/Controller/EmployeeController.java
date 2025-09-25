package com.example.demo.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;

@RestController
@RequestMapping("/Api")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

    @GetMapping("/name")
    public String getName(){
        return "Home";
    }
   
    @PostMapping("/save")
    public Employee savEmployee(@RequestParam String name, @RequestParam BigDecimal salary){
        return employeeService.savEmployee(name, salary);
    }

    @GetMapping("all")
    public List<Employee> getEmployeesBySalary(){
        return employeeService.getEmployeesBySalary();
    }
    
}
